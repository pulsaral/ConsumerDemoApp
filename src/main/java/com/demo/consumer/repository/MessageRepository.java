package com.demo.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.consumer.document.Message;

public interface MessageRepository extends MongoRepository<Message, String> {}