package com.microservice.addressservice.controller;

import com.microservice.addressservice.request.AddressRequest;
import com.microservice.addressservice.response.AddressResponse;
import com.microservice.addressservice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addressService")
public class AddressController {

    @Autowired
    private AddressService addressService ;

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest createAddressRequest) {
        return addressService.createAddress(createAddressRequest) ;
    }

    @GetMapping("/getAddressById/{id}")
    public AddressResponse getAddressById(@PathVariable long id) {
        return addressService.getAddressById(id) ;
    }
}
