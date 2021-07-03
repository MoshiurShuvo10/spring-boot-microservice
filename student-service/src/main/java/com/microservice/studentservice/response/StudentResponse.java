package com.microservice.studentservice.response;

import com.microservice.studentservice.entity.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentResponse {
    private long studentId ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private AddressResponse addressResponse ;

    public StudentResponse(Student student) {
        this.studentId = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
    }
}
