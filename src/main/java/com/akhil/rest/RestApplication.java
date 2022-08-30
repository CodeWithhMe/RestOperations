package com.akhil.rest;

import com.akhil.rest.consume.get.ConsumerUsingRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
        ConsumerUsingRestTemplate consumerUsingRestTemplate = new ConsumerUsingRestTemplate();
        consumerUsingRestTemplate.consumeUsingRestTemplate();
    }
}
