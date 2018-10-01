package com.xulihuazj.uaaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 开启Eureka Client
@EnableEurekaClient
public class UaaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaServiceApplication.class, args);
    }
}
