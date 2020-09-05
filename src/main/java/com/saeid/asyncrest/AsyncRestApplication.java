package com.saeid.asyncrest;

import com.saeid.asyncrest.kafka.KafkaMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AsyncRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncRestApplication.class, args);
    }

    @Bean
    KafkaMessageListener getKafkaConsumer(){
        return new KafkaMessageListener();
    }

}
