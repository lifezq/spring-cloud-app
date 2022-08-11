package com.yql.springcloudapp.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @Package com.yql.springcloudapp.config
 * @ClassName RibbonClientRule
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/10
 */
//@Configuration
public class RibbonClientRule {
    @Bean
    public IRule randomRule() {
        return new RandomRule();
    }

    //    @Bean
//    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//    }
}