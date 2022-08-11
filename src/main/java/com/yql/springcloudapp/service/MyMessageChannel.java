package com.yql.springcloudapp.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Package com.yql.springcloudapp.service
 * @ClassName MyMessageChannel
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
public interface MyMessageChannel {
    String out = "output";
    String in = "input";

    @Output(out)
    MessageChannel out();


    @Input(in)
    SubscribableChannel in();
}
