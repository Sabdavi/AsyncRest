package com.saeid.asyncrest.controller;

import com.saeid.asyncrest.kafka.KafkaProducer;
import com.saeid.asyncrest.model.ServiceRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    final
    KafkaProducer kafkaProducer;

    public Controller(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @RequestMapping(path = "/submit",method = RequestMethod.POST)
    public ResponseEntity<String> submitRequest(@RequestBody ServiceRequest serviceRequest)  {
        kafkaProducer.sendServiceRequestMessage(serviceRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
   /* @RequestMapping(path = "/testingAsync")
    public void value() throws ExecutionException, InterruptedException, TimeoutException {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        String baseUrl = "http://localhost:8080/message";


        final DeferredResult<String> result = new DeferredResult<>();
        ListenableFuture<ResponseEntity<String>> futureEntity = restTemplate.getForEntity(baseUrl,String.class);

        futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
            @Override
            public void onSuccess(ResponseEntity<String> result) {
                System.out.println("Deferred result ");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.printf(ex.getMessage());

            }
        });
    }*/
}
