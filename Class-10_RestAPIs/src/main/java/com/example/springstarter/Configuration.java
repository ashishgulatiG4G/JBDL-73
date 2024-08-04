package com.example.springstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


@Profile("dev")
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

}
