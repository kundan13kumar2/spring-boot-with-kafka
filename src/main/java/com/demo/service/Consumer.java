/*
package com.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "#{'${spring.kafka.topics}'.split(',')}", groupId = "#{'${spring.kafka.consumer.group-id}'}", containerFactory = "kafkaListenerContainerFactory")
    public void consumeRecords(ConsumerRecord<String, String> record, Acknowledgment ack) {

        String json = record.value().toString();
        try {
            logger.info("Consuming message {} Kundan", json);

        } catch (Exception e) {
            logger.info("Message consumption failed for message {}", json);
        } finally {
            ack.acknowledge();
        }
    }


}
*/
