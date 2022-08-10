package com.yql.springcloudapp.config;

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
public class AppConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
