package com.example.Class_18_REDIS.controller;

import com.example.Class_18_REDIS.dto.PersonCreateRequest;
import com.example.Class_18_REDIS.model.Person;
import com.example.Class_18_REDIS.service.PersonService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;


    /*
    String op
     */
    @PostMapping("create")
    public String createPerson(@RequestBody PersonCreateRequest personCreateRequest) {
        return personService.createAsAString(personCreateRequest.to());
    }

    @GetMapping("getAll")
    public List<Person> getPersons() {
        return personService.get();
    }

    /*
    Hash op
     */
    @PostMapping("/hash")
    public String createAsHash(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        return personService.createAsHash(personCreateRequest.to());
    }


    /*
    List op
     */
    @PostMapping("/list")
    public void createAsList(@RequestBody @Valid PersonCreateRequest personCreateRequest) {
        personService.lpush(personCreateRequest.to());
    }


}
