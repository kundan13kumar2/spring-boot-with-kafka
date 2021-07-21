/*

package com.demo.service;


import com.springboot.producer.MessageProducer;
import com.springboot.producer.dto.ProducerAckEnum;
import com.springboot.producer.dto.ProducerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerImpl {
    private static final Logger logger = LoggerFactory.getLogger(ProducerImpl.class);
    private static final String TOPIC = "test-topic";

    @Autowired
    MessageProducer producer;

    public ProducerProperties getProducerProperties(boolean isTxn) {
        List<String> brokerConfig = new ArrayList<>();
        brokerConfig.add("localhost:9092");

        ProducerProperties.Builder builder;
        if (isTxn) {
            builder = new ProducerProperties.Builder(brokerConfig, "txn-" + 2000210, "true");
            builder.transactionTimeout(180000);
        } else
            builder = new ProducerProperties.Builder(brokerConfig);

        builder
                .producerAckEnum(ProducerAckEnum.ALL_REPLICA_RECEIVE)
                .requestTimeout(180000);

        return builder.build();
    }


    public void sendMessage(String message) {

        ProducerProperties properties = getProducerProperties(false);
        logger.info(String.format("#### -> Producing non-txn message -> %s", message));
        producer.sendMessage(TOPIC, message, properties);
        producer.sendMessageSpring(TOPIC, message);
    }

    public void sendMessage(String message, boolean commit) {

        ProducerProperties properties = getProducerProperties(true);
        logger.info(String.format("#### -> Producing txn message -> %s", message));
        producer.sendTxnMessage(TOPIC, message, commit, properties);
        producer.sendTxnMessageSpring(TOPIC, message);
    }

}


*/
