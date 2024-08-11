package com.example.Class_12_RequestClasses.controller;


import com.example.Class_12_RequestClasses.UserDao;
import com.example.Class_12_RequestClasses.dto.UserRegistrationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("/create")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        if(userDao.registerUser(userRegistrationRequest.to()))
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User Registered Successfully");
        else
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("User Registered Successfully");
    }

//    @PostMapping("/create")
//        public String registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
//        userDao.registerUser(userRegistrationRequest.to());
//        return "User Registered Successfully";
//    }



}


/*
    Reponse entity -> build http headers
        -> HTTP status codes
        headers and body


 */