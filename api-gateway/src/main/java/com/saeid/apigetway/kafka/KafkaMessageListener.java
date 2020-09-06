package com.saeid.apigetway.kafka;


import com.saeid.apigetway.model.ServiceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class KafkaMessageListener {

    public static final String API_SERVER_PROTOCOL = "http://";

    @KafkaListener(topics = "${service.topic.name}", containerFactory = "serviceRequestConcurrentKafkaListenerContainerFactory")
    public Future<ResponseEntity<String>> serviceRequestListener(ServiceRequest serviceRequest) {
        System.out.println("Receive service message: " + serviceRequest);

        CompletableFuture<ResponseEntity<String>> future = new CompletableFuture<>();
        RestTemplate restTemplate = new RestTemplate();
        String url = createUrl(serviceRequest);

        Executors.newCachedThreadPool().submit(() -> {
            ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
            future.complete(entity);
            return null;
        });
        return future;
    }

    private String createUrl(ServiceRequest serviceRequest) {
        return API_SERVER_PROTOCOL + serviceRequest.getServer() + ":" + serviceRequest.getPort() + serviceRequest.getPath();
    }
}
