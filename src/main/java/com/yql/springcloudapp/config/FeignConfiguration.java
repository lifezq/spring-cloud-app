package com.yql.springcloudapp.config;

import com.yql.springcloudapp.client.impl.EchoServiceFallback;
import feign.Logger;
import feign.codec.Decoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.yql.springcloudapp.config
 * @ClassName FeignConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/11
 */
@Configuration
public class FeignConfiguration {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    //feign拦截器，设置header信息
//    @Bean
//    FeignInterceptor feignInterceptor() {
//        return new FeignInterceptor();
//    }

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
    }

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {

        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new GateWayMappingJackson2HttpMessageConverter());

        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return httpMessageConverters;
            }
        };
    }

    public class GateWayMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

        GateWayMappingJackson2HttpMessageConverter() {

            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"));
            mediaTypes.add(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"));
            setSupportedMediaTypes(mediaTypes);
        }
    }
}
