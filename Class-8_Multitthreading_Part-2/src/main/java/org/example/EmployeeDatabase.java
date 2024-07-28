package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    public static List<Employee> addEmployee() {
        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < 10000000; i++) {
            employees.add(new Employee(i, "Random", i*10));
        }

        return employees;
    }

}
