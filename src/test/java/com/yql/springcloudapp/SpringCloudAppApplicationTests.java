package com.yql.springcloudapp;

import com.yql.springcloudapp.client.EchoService;
import com.yql.springcloudapp.config.RibbonClientRule;
import com.yql.springcloudapp.service.MyMessageChannel;
import org.apache.rocketmq.common.message.MessageConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@EnableFeignClients
@EnableBinding(MyMessageChannel.class)
@RibbonClient(value = "myRibbonClientRule", configuration = RibbonClientRule.class)
@SpringBootTest
@EnableDiscoveryClient
class SpringCloudAppApplicationTests {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyMessageChannel output;

    @Autowired
    private EchoService echoService;

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
        for (int i = 0; i < 2; i++) {
            ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-app");
            String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
            System.out.println("request url:" + url);
            System.out.println(restTemplate.getForObject(url, String.class));
        }
    }

    @Test
    public void testRocketMQ() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "tagStr");
        Message message = MessageBuilder.createMessage("my mq msg.data", new MessageHeaders(headers));
        output.out().send(message);
    }

    @Test
    public void testFeign() {
        System.out.println(echoService.echo("ZhangSan"));
    }
}
