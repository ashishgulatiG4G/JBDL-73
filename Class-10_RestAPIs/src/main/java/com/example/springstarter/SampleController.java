package com.example.springstarter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

    @GetMapping("/")
    public String sayHelloWorld() {
        log.info("Trace log");
        return "Hello, World!";
    }

    @GetMapping("/hello/{name}/{id}")
    public String sayHelloWorld1(@PathVariable("name") String NAME,
                                 @PathVariable("id") int rollNumber) {
        return "Hello, World!" + NAME + ", rollNumber : " + rollNumber;
    }

    @GetMapping("/hello")
    public String sayHelloWorld2(@RequestParam String name,
                                 @RequestParam(required = false, defaultValue = "12") int id) {
        return "Hello, World!" + name + ", id : " + id;
    }



    // localhost:8080/hello?name=ashish&id=25

}
