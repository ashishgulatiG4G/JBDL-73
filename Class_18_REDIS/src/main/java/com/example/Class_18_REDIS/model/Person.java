package com.example.Class_18_REDIS.model;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Person implements Serializable {

    private String id;

    private String name;

    private String age;

    private Address address;


}
