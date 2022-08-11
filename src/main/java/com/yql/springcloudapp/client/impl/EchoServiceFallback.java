package com.yql.springcloudapp.client.impl;

import com.yql.springcloudapp.client.EchoService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Package com.yql.springcloudapp.client.impl
 * @ClassName EchoServiceFallback
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
public class EchoServiceFallback implements EchoService {


    @Override
    public String echo(@PathVariable("str") String str) {
        return "echo fallback:" + str;
    }
}
