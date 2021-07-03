package com.microservice.addressservice.service;

import com.microservice.addressservice.entity.Address;
import com.microservice.addressservice.repository.AddressRepository;
import com.microservice.addressservice.request.AddressRequest;
import com.microservice.addressservice.response.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository ;

    @Override
    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setCity(addressRequest.getCity());
        address.setStreet(addressRequest.getStreet());

        addressRepository.save(address) ;
        return new AddressResponse(address);
    }

    @Override
    public AddressResponse getAddressById(long id) {
        Address address = addressRepository.findById(id).get() ;
        return new AddressResponse(address) ;
    }
}
