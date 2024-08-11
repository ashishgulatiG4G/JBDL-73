package com.example.Class_13_JPA_Hibernate.dto;

import com.example.Class_13_JPA_Hibernate.model.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

/*
    Values will be null without setters

 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateEmployeeRequest {


    // Server should generate the ID
    // Client shouldn't be passing it
    //    private String Id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private Date DOB;

    private String homeAddress;


    public Employee to() {

        Integer age = convertDOBToAge(this.DOB);
        String hashedPassword = hashPassword(this.password);

        return Employee
                .builder()
                .name(this.name)
                .password(hashedPassword)
                .age(age)
                .homeAddress(this.homeAddress)
                .build();

    }

    public Integer convertDOBToAge(Date dob) {
        return 25;
    }

    public String hashPassword(String password) {
        return password;
    }

}
