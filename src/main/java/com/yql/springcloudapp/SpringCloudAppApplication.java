package com.yql.springcloudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppApplication.class, args);
    }

}
