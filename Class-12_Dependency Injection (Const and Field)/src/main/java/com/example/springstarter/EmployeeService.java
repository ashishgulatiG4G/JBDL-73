package com.example.springstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public String getName() {
        return "Ashish";
    }

}
