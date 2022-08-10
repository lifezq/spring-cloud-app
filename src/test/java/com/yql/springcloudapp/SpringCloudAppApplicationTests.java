package com.yql.springcloudapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@SpringBootTest
@EnableDiscoveryClient
class SpringCloudAppApplicationTests {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;


    @Test
    void contextLoads() throws UnsupportedEncodingException {

        String userName = ctx.getEnvironment().getProperty("user.name");
        String userAge = ctx.getEnvironment().getProperty("user.age");
        System.err.println("user name :" + userName + "; age: " + userAge);


        System.out.println(new String(userName.getBytes(StandardCharsets.ISO_8859_1), "utf-8"));
    }

    @Test
    public void testNacosDiscovery() {
        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-app");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        System.out.println("request url:" + url);
        System.out.println(restTemplate.getForObject(url, String.class));
    }
}
