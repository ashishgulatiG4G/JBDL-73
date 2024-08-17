package com.example.Class_13_JPA_Hibernate.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private Date DOB;

    @Column(name="address")
    private String homeAddress;             // camelCase -> home_address
    private String company;
    private String city;


}
