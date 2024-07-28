package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatabase.addEmployee();

        long start = System.currentTimeMillis();
        double salaryAvgUsingStream = employeeList.stream().
                map(Employee::getsalary).
                mapToDouble(i -> i).average().getAsDouble();
        long timeTaken = System.currentTimeMillis() - start;
        System.out.println("Time take in normal stream: {}"+ timeTaken);


        long start2 = System.currentTimeMillis();
        double salaryAvgUsingParallelStream = employeeList.parallelStream().
                map(Employee::getsalary).
                mapToDouble(i -> i).average().getAsDouble();
        long timeTaken2 = System.currentTimeMillis() - start2;
        System.out.println("Time take in parallel stream: {}"+ timeTaken2);


    }

}
