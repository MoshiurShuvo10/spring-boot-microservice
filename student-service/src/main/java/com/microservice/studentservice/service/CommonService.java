package com.microservice.studentservice.service;

import com.microservice.studentservice.feignClients.CustomFeignClient;
import com.microservice.studentservice.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommonService {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(CommonService.class) ;
    int count = 0;

    @Autowired
    CustomFeignClient customFeignClient ;

    // we are calling address service via feign client. so, need to configure circuit breaker in this method
    @CircuitBreaker(name = "addressService", fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById(long addressId) {
        count++ ;
        logger.info("total number of request to address-service: "+count);
        return customFeignClient.getAddressById(addressId);
    }

    public AddressResponse fallbackGetAddressById(long addressId, Throwable throwable) {

        // return a dummy response, as we're not getting the correct response from address service.
        logger.error("fallback method:: "+ String.valueOf(throwable));
        return new AddressResponse();
    }
}
