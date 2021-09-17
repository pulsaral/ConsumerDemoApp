package com.demo.consumer.document;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "message")
public class Message {
	
	private String topic;
	
	private String message;

}
