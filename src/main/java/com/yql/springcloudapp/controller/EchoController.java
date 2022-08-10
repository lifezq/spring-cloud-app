package com.yql.springcloudapp.controller;

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
    @GetMapping(value = "/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}
