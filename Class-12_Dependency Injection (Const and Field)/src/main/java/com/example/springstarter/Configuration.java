package com.example.springstarter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


//@Profile("dev")
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public EmployeeEntity employeeEntity() {
        return new EmployeeEntity(2);
    }

}
