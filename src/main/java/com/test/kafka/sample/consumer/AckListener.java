package com.test.kafka.sample.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class AckListener implements AcknowledgingMessageListener<Integer, String> {
    private static final Logger logger = LoggerFactory.getLogger(AckListener.class);

    public AckListener(){

    }
    @Override
    public void onMessage(ConsumerRecord<Integer,String> consumerRecord, Acknowledgment acknowledgment){
        logger.info("*************** Message Received = " + consumerRecord.toString() + " , " + acknowledgment);
        try {
            Thread.sleep(7000);
            acknowledgment.acknowledge();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
