package com.yql.springcloudapp.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @Package com.yql.springcloudapp.service
 * @ClassName RocketMQService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
@Service
public class RocketmqService {
    @StreamListener(MyMessageChannel.in)
    public void receiveInputMessage(String receivedMessage) {
        System.out.println("input receive msg:" + receivedMessage);
    }
}
