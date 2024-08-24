package com.example.Class_15_MinorProject.controller;

import com.example.Class_15_MinorProject.dto.CreateStudentRequest;
import com.example.Class_15_MinorProject.dto.SearchRequest;
import com.example.Class_15_MinorProject.dto.SearchStudentResponse;
import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.service.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
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
    // findStudentByEmail
    @GetMapping("/find")
    public ResponseEntity<SearchStudentResponse> findStudent(@RequestBody @Valid SearchRequest searchRequest) {
        try {
            Student student =  studentService.findStudent(
                    searchRequest.getSearchKey(),
                    searchRequest.getSearchValue()
            );
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(student.to());
        } catch (Exception e) {

            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(SearchStudentResponse.createErrorResponse(e.getMessage()));
        }
    }

}
