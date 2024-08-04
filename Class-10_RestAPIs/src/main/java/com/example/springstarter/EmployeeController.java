package com.example.springstarter;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public String createEmployee(@RequestBody Employee employee) {
        this.employeeHashMap.put(employee.getId(), employee);
        return "Created Successfully";
    }

    // R -> Read
    @GetMapping("getEmployees")
    public Map<Integer, Employee> getEmployees() {
        return this.employeeHashMap;
    }

    // Read
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {
        if(employeeHashMap.containsKey(id))
            return employeeHashMap.get(id);
        return new Employee("InvalidUser", 0, 0);
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
    public String updateEmployee(@RequestBody @Valid Employee employee) {
        if(employee.getId() == null || !employeeHashMap.containsKey(employee.getId())) {
            return "Invalid User";
        }
        this.employeeHashMap.put(employee.getId(), employee);
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
