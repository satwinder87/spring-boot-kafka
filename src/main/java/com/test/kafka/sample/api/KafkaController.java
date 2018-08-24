package com.test.kafka.sample.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {
    private KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate<Integer,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @RequestMapping(value = "/push-message", method = RequestMethod.POST)
    public void pushMessage(){
        Message<String> message = MessageBuilder.withPayload("Hello Event Message")
                .setHeader(KafkaHeaders.TOPIC,"test")
                .setHeader("eventType","TELEPHONY_SUBSCRIPTION_EVENTs")
                .build();
        kafkaTemplate.send(message);
    }
}
