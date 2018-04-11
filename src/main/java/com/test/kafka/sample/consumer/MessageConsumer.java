package com.test.kafka.sample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive(String payload) {
        logger.info("Message Received From Topic : " + payload);
        //System.out.println("received payload='{}'" +  payload);
    }
}
