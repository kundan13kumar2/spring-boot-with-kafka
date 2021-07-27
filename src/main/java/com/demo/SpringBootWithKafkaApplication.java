package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableKafka
//@EnableTransactionManagement
@SpringBootApplication
//@ComponentScan(basePackages = {"com.demo", "com.springboot.producer", "com.springboot.consumer"})
@ComponentScan(basePackages = {"com.demo"})
public class SpringBootWithKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithKafkaApplication.class, args);
    }

//    @Bean("dstm")
//    public DataSourceTransactionManager dstm(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
