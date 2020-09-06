package com.saeid.apigetway;

import com.saeid.apigetway.kafka.KafkaMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    KafkaMessageListener getKafkaConsumer() {
        return new KafkaMessageListener();
    }

}
