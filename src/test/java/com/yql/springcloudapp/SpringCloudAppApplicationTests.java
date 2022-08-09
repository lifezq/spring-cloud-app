package com.yql.springcloudapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringCloudAppApplicationTests {
    @Autowired
    ApplicationContext ctx;

    @Test
    void contextLoads() {
        String userName = ctx.getEnvironment().getProperty("user.name");
        String userAge = ctx.getEnvironment().getProperty("user.age");
        System.err.println("user name :" + userName + "; age: " + userAge);
    }
}
