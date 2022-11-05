package com.hp.kafkademo.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/{request}")
    public void publish(@PathVariable("request") String request) {
        kafkaTemplate.send("hp", request);
    }
}
