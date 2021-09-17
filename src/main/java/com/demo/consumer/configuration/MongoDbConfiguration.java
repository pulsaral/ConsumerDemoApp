package com.demo.consumer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.demo.consumer.repository.MessageRepository;


@Configuration
@EnableMongoRepositories(basePackageClasses = MessageRepository.class)
public class MongoDbConfiguration {}
