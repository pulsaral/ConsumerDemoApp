package com.demo.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.demo.consumer.document.Message;

@Component
public class ConsumerService {

    @Autowired
    private SimpMessagingTemplate template;
    
    @Autowired
	private MongoRepository<Message, String> mongoDbRepository;

    @KafkaListener(topics = {"testtopic", "testtopic1"})
    public void processMessage(ConsumerRecord<?, ?> record){
    	System.out.println("Consumed from topic: " + record.topic() + " Message: " + record.value());
		
		// Save to db
		Message message = new Message(record.topic(), record.value().toString());
		mongoDbRepository.save(message);
		
		// Push to client
        this.template.convertAndSend("/topic/pushNotification", message);
    }
    
}
