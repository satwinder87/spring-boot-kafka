package com.test.kafka.sample.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

public class MessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

////    @KafkaListener(topics = "${kafka.topic.name}")
////    public void receive(@Header("eventType") EventType eventType, String payload, Acknowledgment acknowledgment) {
////        logger.info("Message Received From Topic : " + payload + " , Header = " + eventType.name());
////        acknowledgment.acknowledge();
////        //System.out.println("received payload='{}'" +  payload);
////    }
//
//    @Retryable(value = {RuntimeException.class, Exception.class}, maxAttempts = 5, backoff = @Backoff(delay=5000))
//    @KafkaListener(id="ourId",topics = "${kafka.topic.name}",groupId = "test")
//    public void receive(String payload, Acknowledgment acknowledgment) {
//        logger.info("Consumer_1 : Message Received From Topic [{}] at time [{}] " , payload, new Date());
//        if(payload.contains("hello")){
//            acknowledgment.acknowledge();
//            System.out.println("Acknowledged");
//        }else {
//            throw new RuntimeException("Invalid Message Received");
//        }
//    }
//
//    @Retryable(value = {RuntimeException.class, Exception.class}, maxAttempts = 5, backoff = @Backoff(delay=5000))
//    @KafkaListener(id="otherId",topics = "${kafka.topic.name}",groupId = "test2")
//    public void receive2(String payload, Acknowledgment acknowledgment) {
//        logger.info("Consumer_2 : Message Received From Topic [{}] at time [{}] " , payload, new Date());
//        acknowledgment.acknowledge();
////        if(payload.contains("hello")){
////            acknowledgment.acknowledge();
////            System.out.println("Acknowledged");
////        }else {
////            throw new RuntimeException("Invalid Message Received");
////        }
//    }
//
//    @Recover
//    public void recover(RuntimeException exception){
//        System.out.println("*********** Recovered Method Called *******");
//        throw new RuntimeException("Failed Even After All Retries");
//    }


    @KafkaListener(topics = "${kafka.topic.name}")
    public void receive2(String payload, Acknowledgment acknowledgment) {
        logger.info("Message Received From Topic : " + payload);
        System.out.println("Receiver_2 : received payload='{}'" +  payload);
        if(payload.contains("hello")){
            acknowledgment.acknowledge();
            System.out.println("Acknowledged By Second");
        }else {
            throw new RuntimeException("Invalid Message Received By Second");
        }

    }
}
