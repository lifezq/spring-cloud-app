package com.yql.springcloudapp.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @Package com.yql.springcloudapp.exception
 * @ClassName ExceptionUtil
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
public class ExceptionUtil {
    public static ClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        return new SentinelClientHttpResponse();
    }
}