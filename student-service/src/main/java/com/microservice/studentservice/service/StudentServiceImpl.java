package com.microservice.studentservice.service;

import com.microservice.studentservice.entity.Student;
import com.microservice.studentservice.feignClients.CustomFeignClient;
import com.microservice.studentservice.repository.StudentRepository;
import com.microservice.studentservice.request.StudentRequest;
import com.microservice.studentservice.response.AddressResponse;
import com.microservice.studentservice.response.StudentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CommonService commonService ;

    @Autowired
    CustomFeignClient customFeignClient ;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {

        // Here, Entity is Student. So, convert Student Request object into Student to save into database.
        Student student = new Student() ;
        student.setAddressId(studentRequest.getAddressId());
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());

        student = studentRepository.save(student) ;

        // Now, create a response dto from Student object so that we can view the saved object in postman.
        StudentResponse studentResponse = new StudentResponse(student) ;

        // calling address-service using web-client.
        // studentResponse.setAddressResponse(getAddressById(student.getAddressId()));


        // calling address-service using feign-client
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
        return studentResponse ;
    }




    @Override

    public StudentResponse getStudentById(long id) {
        Student student = studentRepository.findById(id).get() ;
        StudentResponse studentResponse = new StudentResponse(student) ;
        // studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        // calling address-service using address-feign-client
        studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));

        return studentResponse ;
    }
}
