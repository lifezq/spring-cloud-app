package com.yql.springcloudapp.config;

import com.yql.springcloudapp.client.impl.EchoServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.yql.springcloudapp.config
 * @ClassName FeignConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
