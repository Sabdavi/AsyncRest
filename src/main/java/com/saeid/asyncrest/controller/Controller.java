package com.saeid.asyncrest.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class Controller {
    @RequestMapping(path = "/message")
    public ResponseEntity<String> showMessage() throws InterruptedException {
        Thread.sleep(10*1000);
        return ResponseEntity.ok("Async Api!");
    }
    @RequestMapping(path = "/testingAsync")
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
    }
}
