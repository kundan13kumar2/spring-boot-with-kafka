
package com.demo.controllers;

import com.demo.model.Customer;
import com.demo.model.User;
import com.demo.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

//    @Autowired
//    private ProducerImpl producerImpl;

    @Autowired
    private TransactionalService txnService;

   /* @GetMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producerImpl.sendMessage(message);
    }

    @GetMapping(value = "/publishTxn")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message, @RequestParam("commit") String commit) {
        boolean isCommit = Boolean.parseBoolean(commit);
        this.producerImpl.sendMessage(message, isCommit);
    }*/


    @GetMapping(value = "/test")
    public String getTest(@RequestParam(value = "name") String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/saveData")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "email", defaultValue = "abc@gmail.com") String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return txnService.doInSingleTxn(user);
    }

    @PostMapping(value = "/saveEvents")
    public String addEvent(@RequestBody Customer customer) {
        return txnService.doInTxn(customer);
    }

}
