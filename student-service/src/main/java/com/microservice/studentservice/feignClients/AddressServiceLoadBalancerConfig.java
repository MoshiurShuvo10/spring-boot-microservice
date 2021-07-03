package com.microservice.studentservice.feignClients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

// we're setting load balancer for address service
@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancerConfig {


    // When we start student-service It'll configure the feign builder and at that time, we're saying that it should be
    // load balanced. And this load balanced feign client will be used for address service
    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder() ;
    }
}
