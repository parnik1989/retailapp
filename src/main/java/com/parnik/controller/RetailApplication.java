package com.parnik.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.parnik")
public class RetailApplication {

	 
    public static void main(String[] args) {
        SpringApplication.run(RetailApplication.class, args);
    }  
}
