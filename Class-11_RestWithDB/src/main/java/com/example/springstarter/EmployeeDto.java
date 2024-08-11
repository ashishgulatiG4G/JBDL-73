package com.example.springstarter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

    @NotBlank
    private String name;
    @NotNull
    private Integer age;

}
