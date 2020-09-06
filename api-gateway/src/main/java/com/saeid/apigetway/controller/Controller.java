package com.saeid.apigetway.controller;


import com.saeid.apigetway.kafka.KafkaMessageListener;
import com.saeid.apigetway.kafka.KafkaProducer;
import com.saeid.apigetway.model.ServiceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class Controller {
    final
    KafkaProducer kafkaProducer;
    final
    KafkaMessageListener kafkaMessageListener;

    public Controller(KafkaProducer kafkaProducer, KafkaMessageListener kafkaMessageListener) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageListener = kafkaMessageListener;
    }


    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public ResponseEntity<String> submitRequest(@RequestBody ServiceRequest serviceRequest) throws ExecutionException, InterruptedException {
        kafkaProducer.sendServiceRequestMessage(serviceRequest);
        Future<ResponseEntity<String>> future = kafkaMessageListener.serviceRequestListener(serviceRequest);
        ResponseEntity<String> entity = future.get();
        return entity;
    }
}
