package com.example.Class_13_JPA_Hibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity
@ToString
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private Date DOB;

    @Column(name="address")
    private String homeAddress;             // camelCase -> home_address
    private String company;
    private String city;
}


/*
    GeneratedValue -> annotation used in JPA with Hibernate
        defines how PK is generated (using auto increment


1. Identity -> Underlying DB will generate an id
2. AUTO -> hibernate will generate id and pass it in insert query
3. UUID ->

 */




/*


    //    public Employee() {
//
//    }
//
//    public Employee(String name, String password) {
//
//    }
//
//    public Employee(String name, String password, String age) {
//
//    }
//
//    public Employee(String name, String password, String age, String homeAddress, Date dob) {
//
//    }

    Why we need builder? (Can't we just use constructors)

    To reduce object creation boiler plate code -> can't we use lombok annotation (@AllArgsConstructor)

    What if we want to set lesser number of params in constructor

    Builder DP -> Separates the construction of object creation from a complex object so that we can
    create different representations

 */