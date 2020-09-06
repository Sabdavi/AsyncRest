package com.saeid.apiclient;

import com.saeid.apiclient.model.ServiceRequest;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class Test {
    private static final String GATEWAY_ADDRESS = "http://localhost:8080";
    private static final String GATEWAY_SUBMIT_PATH = "/submit";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ServiceRequest> request = new HttpEntity<>(new ServiceRequest("localhost", 8081, "/message"));
        String response = restTemplate.postForObject(GATEWAY_ADDRESS + GATEWAY_SUBMIT_PATH, request, String.class);
        System.out.printf(response);

    }
}
