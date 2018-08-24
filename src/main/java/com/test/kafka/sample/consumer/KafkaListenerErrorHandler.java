package com.test.kafka.sample.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerErrorHandler implements ErrorHandler {

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> record) {
        kafkaListenerEndpointRegistry.getListenerContainers().forEach(item -> System.out.println("Consumer = " + item.toString()));
        System.out.println("************* SHUT DOWN STARTED **********");
        //kafkaListenerEndpointRegistry.stop();  // Will shutdown all the ListenerContainers
        kafkaListenerEndpointRegistry.getListenerContainer("ourId").stop();   //Stop specific consumer
        System.out.println("************* SHUT DOWN COMPLETED **********");
        kafkaListenerEndpointRegistry.getListenerContainers().forEach(item -> System.out.println("Consumer = " + item.toString()));
    }

}
