package com.saeid.apigetway.kafka;


import com.saeid.apigetway.model.ServiceRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {
    private final KafkaTemplate<String, ServiceRequest> serviceRequestKafkaTemplate;

    @Value(value = "${service.topic.name}")
    private String impressionTopicName;

    public KafkaProducer(KafkaTemplate<String, ServiceRequest> serviceRequestKafkaTemplate) {
        this.serviceRequestKafkaTemplate = serviceRequestKafkaTemplate;
    }

    public void sendServiceRequestMessage(ServiceRequest serviceRequest) {
        serviceRequestKafkaTemplate.send(impressionTopicName, serviceRequest);
    }
}

