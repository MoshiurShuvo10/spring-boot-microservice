package com.microservice.studentservice.feignClients;

import com.microservice.studentservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "api-gateway")
// by using FeignClient value="api-gateway", this customFeignClient is used for calling any microservice via api-gateway.
public interface CustomFeignClient {

    // from studentService, using this address feing client,  we want to call address-service getById api.
    // So just need to put the method signature, not the implementation.
    @GetMapping("/address-service/api/v1/addressService/getAddressById/{id}")
    public AddressResponse getAddressById(@PathVariable long id) ;
}
