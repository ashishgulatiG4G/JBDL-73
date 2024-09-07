package com.example.springsecurity.controller;

import com.example.springsecurity.model.User;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
//@EnableMethodSecurity(jsr250Enabled = true)
public class UserController {

    @Autowired
    UserService userService;

    /*
        Signup API - OPEN for all
     */
    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // This should be open for ADMIN role
    @GetMapping("/all")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAll();
    }


}
