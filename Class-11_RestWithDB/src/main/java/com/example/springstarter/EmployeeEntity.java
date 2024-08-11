package com.example.springstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class EmployeeEntity {


    @Autowired
    EmployeeController employeeController;
    int value;

    @Autowired
    public EmployeeEntity(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
//
    public EmployeeEntity(int a) {
        this.value = a;
    }





}


// IOC -> bean creation -> IOC container

// DI -> Get the bean

/*
    For IOC to work properly, there needs to be either a default constructor or a parameter constructor
        where param is a bean itself




 */