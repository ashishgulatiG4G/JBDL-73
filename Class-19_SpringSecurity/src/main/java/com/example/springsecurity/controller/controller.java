package com.example.springsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class controller {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/hello1")
    public String sayHello1() {
        return "Hello 1";
    }

    @GetMapping("/hello2")
    public String sayHello2() {
        return "Hello 2";
    }

}
