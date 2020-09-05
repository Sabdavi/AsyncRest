package com.saeid.asyncrest.kafka;


import com.saeid.asyncrest.model.ServiceRequest;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaMessageListener {


    @KafkaListener(topics = "${service.topic.name}", containerFactory = "serviceRequestConcurrentKafkaListenerContainerFactory")
    public void serviceRequestListener(ServiceRequest serviceRequest) {
        System.out.println("Recieved impression message: " + serviceRequest);
        //adEventService.saveAdEvent(impressionEvent);

    }
}
