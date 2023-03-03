package com.example.quantsysdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QuantsysDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuantsysDemoApplication.class, args);
    }
}
