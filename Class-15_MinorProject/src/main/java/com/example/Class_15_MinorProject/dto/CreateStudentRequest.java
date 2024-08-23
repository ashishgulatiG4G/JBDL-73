package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateStudentRequest {


    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String rollNumber;
    @NotBlank
    private Integer age;

    public Student to() {
        return Student.builder()
                .name(this.name)
                .age(this.age)
                .email(this.email)
                .rollNumber(this.rollNumber)
                .build();
    }


}
