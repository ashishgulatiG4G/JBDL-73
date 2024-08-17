package com.example.Class_13_JPA_Hibernate.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;

    // unidirectional
    @OneToOne
    private Profile profile;


    // bidirectional
    @OneToMany
    private List<Order> coursesList;


    // bidirectional
    @ManyToMany
    private Set<Courses> coursesSet = new HashSet<>();


}


/*

    2 entities -> relationship between them

    different types of relationships

    1. OneToOne relationship
    2. OneToMany
    3. ManyToOne
    4. Many to Many


    Unidirectional -> Where only one table is aware of the relationship
    Bidirectional -> Where both the entities are aware

 */