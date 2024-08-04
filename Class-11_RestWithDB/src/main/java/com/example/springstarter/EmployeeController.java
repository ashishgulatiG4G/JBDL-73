package com.example.springstarter;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Base URL : Domain Name / IP_Address:PORT [127.0.0.1:8080]
 * <p>
 * Base URL/endpoint [API]
 * <p>
 * Steps to write an API:
 *      1. Define an HTTP method [Request Method]
 *      2. Define the end point / API path
 *      3. Define how to take an input
 */
@RestController
public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

//    private final EmployeeService employeeService;

//    @Autowired
//    EmployeeService employeeService;


    private Map<Integer, Employee> employeeHashMap;


    public EmployeeController() {
        employeeHashMap = new HashMap<>();
//        employeeService = new EmployeeService();
    }

    // CRUD

    // C -> Create
    @PostMapping("/createEmployee")
    public String createEmployee(@RequestBody Employee employee) throws SQLException {
        employeeDao.createEmployeeDynamic(employee);
        return "Created Successfully";
    }

    // R -> Read
    @GetMapping("getEmployees")
    public List<Employee> getEmployees() throws SQLException {
        return employeeDao.getEmployees();
    }

    // Read
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) throws SQLException {
        return employeeDao.getEmployeeById(id);
    }


    /*
    "employee ->
            {
                "name" : "aakash",
                "id" : 3,
                "age" : 20
            }



    */


    // U -> Update
    @PutMapping("/employee/update")
    public String updateEmployee(@RequestBody @Valid Employee employee) throws SQLException {
        this.employeeDao.updateEmployee(employee);
        return "Updated successfully";
    }



    // Update
    @PatchMapping("/employee/patch")
    public String patchUpdateEmployee(@RequestBody Employee employee) {
        if(employee.getId() == null || !employeeHashMap.containsKey(employee.getId())) {
            return "Invalid User";
        }
        Employee existingEmployee = employeeHashMap.get(employee.getId());

        if(employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }

        if(employee.getAge() != null) {
            existingEmployee.setAge(employee.getAge());
        }

        return "Patch applied successfully";
    }

    // TODO - Add the api for delete

}
