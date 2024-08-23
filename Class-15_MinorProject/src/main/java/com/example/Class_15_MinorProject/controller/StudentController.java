package com.example.Class_15_MinorProject.controller;

import com.example.Class_15_MinorProject.dto.CreateStudentRequest;
import com.example.Class_15_MinorProject.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    // create - update
    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        studentService.createOrUpdate(createStudentRequest.to());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Student got added successfully");
    }


    // findStudentById
    // findStudentByRollNumber
    // findStudentByName
    // findStudentByEmail


}
