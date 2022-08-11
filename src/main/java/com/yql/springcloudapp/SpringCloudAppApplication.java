package com.yql.springcloudapp;

import com.yql.springcloudapp.service.MyMessageChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;


@EnableFeignClients
@EnableBinding(MyMessageChannel.class)
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppApplication.class, args);
    }

}
