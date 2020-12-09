package com.czh.geek.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class XaAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(XaAccountApplication.class, args);
    }

}
