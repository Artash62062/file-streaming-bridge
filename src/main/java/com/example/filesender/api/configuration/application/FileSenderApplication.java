package com.example.filesender.api.configuration.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.filesender"})
public class FileSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileSenderApplication.class, args);
    }

}
