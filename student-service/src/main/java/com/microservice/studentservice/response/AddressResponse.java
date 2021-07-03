package com.microservice.studentservice.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddressResponse {
    private long addressId ;
    private String street ;
    private String city ;
}
