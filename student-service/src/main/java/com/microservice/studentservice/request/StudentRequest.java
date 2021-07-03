package com.microservice.studentservice.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentRequest {
    private String firstName ;
    private String lastName ;
    private String email ;
    private long addressId ;
}
