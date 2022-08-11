package com.yql.springcloudapp.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.yql.springcloudapp.exception.ExceptionUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Package com.yql.springcloudapp.config
 * @ClassName AppConfig
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/10
 */
@Configuration
public class AppConfiguration {
    @LoadBalanced
    @Bean
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
