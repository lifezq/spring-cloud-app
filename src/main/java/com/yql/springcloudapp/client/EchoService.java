package com.yql.springcloudapp.client;

import com.yql.springcloudapp.client.impl.EchoServiceFallback;
import com.yql.springcloudapp.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Package com.yql.springcloudapp.client
 * @ClassName EchoService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
@FeignClient(name = "spring-cloud-app", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {
    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);
}

