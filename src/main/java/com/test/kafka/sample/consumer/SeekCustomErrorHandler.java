package com.test.kafka.sample.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.listener.ContainerAwareErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeekCustomErrorHandler implements ContainerAwareErrorHandler {
    public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {
        Map<TopicPartition, Long> offsets = new LinkedHashMap();
        records.forEach((r) -> {
            Long var10000 = (Long)offsets.computeIfAbsent(new TopicPartition(r.topic(), r.partition()), (k) -> {
                return r.offset();
            });
        });
        offsets.forEach(consumer::seek);
        throw new KafkaException("Seek to current after exception", thrownException);
    }
}
