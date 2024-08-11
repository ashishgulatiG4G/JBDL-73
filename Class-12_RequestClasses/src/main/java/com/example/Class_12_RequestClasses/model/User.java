package com.example.Class_12_RequestClasses.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private String username;

    private String password;

    private String userId;

}

// model -> java interpretation of your table
