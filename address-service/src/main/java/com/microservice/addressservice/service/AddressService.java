package com.microservice.addressservice.service;

import com.microservice.addressservice.request.AddressRequest;
import com.microservice.addressservice.response.AddressResponse;

public interface AddressService {
    AddressResponse createAddress(AddressRequest createAddressRequest);

    AddressResponse getAddressById(long id);
}
