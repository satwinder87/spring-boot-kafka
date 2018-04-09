package com.test.kafka.sample.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class MessageConsumer {

    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive(String payload) {
        System.out.println("received payload='{}'" +  payload);
    }
}
