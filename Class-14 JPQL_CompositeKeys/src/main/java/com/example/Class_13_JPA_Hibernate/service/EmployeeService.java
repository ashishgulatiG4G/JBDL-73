package com.example.Class_13_JPA_Hibernate.service;

import com.example.Class_13_JPA_Hibernate.dao.EmployeeDao;
import com.example.Class_13_JPA_Hibernate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public Integer saveEmployee(Employee employee) {
        employeeDao.save(employee);
        return 0;
    }

    public List<Employee> getAllEmployees() {
//        return employeeDao.findEmployeeGreaterThanAgeAndCity(25, "Delhi");
        return employeeDao.findEmployeeGreaterThanAgeAndCityNative(25, "Delhi");
    }
}
