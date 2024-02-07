package com.example.contactify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.contactify")
public class ContactifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactifyApplication.class, args);
    }

}