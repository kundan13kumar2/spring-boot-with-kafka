
package com.demo.service;


import com.springboot.producer.MessageProducer;
import com.springboot.producer.dto.ProducerAckEnum;
import com.springboot.producer.dto.ProducerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerImpl {
    private static final Logger logger = LoggerFactory.getLogger(ProducerImpl.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String brokerConfig;

    @Value("${spring.kafka.topics}")
    private String topics;

    @Autowired
    MessageProducer producer;

    public ProducerProperties getProducerProperties(boolean isTxn) {
        List<String> brokerConfigList = new ArrayList<>();
        brokerConfigList.add(brokerConfig);

        ProducerProperties.Builder builder;
        if (isTxn) {
            builder = new ProducerProperties.Builder(brokerConfigList, "txn-" + 2000210, "true");
            builder.transactionTimeout(180000);
        } else
            builder = new ProducerProperties.Builder(brokerConfigList);

        builder
                .producerAckEnum(ProducerAckEnum.ALL_REPLICA_RECEIVE)
                .requestTimeout(180000);

        return builder.build();
    }


    public void sendMessage(String message) {

        ProducerProperties properties = getProducerProperties(false);
        logger.info(String.format("#### -> Producing non-txn message -> %s", message));
       // producer.sendMessage(topics, message, properties);
        producer.sendMessageSpring(topics, message);
    }

    public void sendMessage(String message, boolean commit) {

        ProducerProperties properties = getProducerProperties(true);
        logger.info(String.format("#### -> Producing txn message -> %s", message));
        //producer.sendTxnMessage(topics, message, commit, properties);
        producer.sendTxnMessageSpring(topics, message);
    }

}


