package com.microservice.studentservice.service;

import com.microservice.studentservice.request.StudentRequest;
import com.microservice.studentservice.response.StudentResponse;

public interface StudentService {
    StudentResponse getStudentById(long id);

    StudentResponse createStudent(StudentRequest studentRequest);
}
