package com.demo.service;

import com.demo.mapper.OrderMyBatisRepository;
import com.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
public class TransactionalService {

    @Autowired
    private OrderMyBatisRepository orderRepo;

/*    @Autowired
    private RetryMyBatisRepository retryRepo;

    @Autowired
    private CustomerMyBatisRepository customerRepo;*/

    //private final JdbcTemplate jdbcTemplate;

//    @Qualifier(value = "nonTxnTemplate")
//    private final KafkaTemplate<String, String> kafkaTemplate;

/*    public TransactionalService(JdbcTemplate jdbcTemplate, KafkaTemplate<String, String> kafkaTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.kafkaTemplate = kafkaTemplate;
    }*/

/*    public TransactionalService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    //, Retry retry
    @Transactional("transactionManager")
    public String doInTxnDummy(Order order) {
        orderRepo.insert(order);
        //  retryRepo.insert(retry);
        return "Saved Successfully!!!";

    }


/*    @Transactional("transactionManager")
    public String doInTxn(Customer customer) {
        customerRepo.insert(customer);
        return "Saved Successfully!!!";

    }


    @Transactional("dstm")
    public String doInSingleTxn(User user) {
        //  kafkaTemplate.send("test-topic", user.toString());
        jdbcTemplate.execute("insert into User(name,email) values('" + user.getName() + "','" + user.getEmail() + "')");
        //    throw new RuntimeException("Helo");
        //
        //    this.sendToKafka(user);
        return "Saved Successfully!!!";
    }*/

   /* @Transactional("kafkaTransactionManager")
    public void sendToKafka(User in) {
        this.kafkaTemplate.send("test-topic1", in.toString());
    }*/

}
