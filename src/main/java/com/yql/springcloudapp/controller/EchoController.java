package com.yql.springcloudapp.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yql.springcloudapp.controller
 * @ClassName EchoController
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/10
 */
@RequestMapping(value = "/echo")
@RestController
public class EchoController {
    @Value("${server.port}")
    private int port;

    @SentinelResource("echo")
    @GetMapping(value = "/{string}")
    public String echo(@PathVariable String string) {
        return port + ":Hello Nacos Discovery " + string;
    }
}
