package com.microservice.studentservice.controller;

import com.microservice.studentservice.request.StudentRequest;
import com.microservice.studentservice.response.StudentResponse;
import com.microservice.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService ;

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponse getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }
}
