package com.example.Class_18_REDIS.dto;

import com.example.Class_18_REDIS.model.Address;
import com.example.Class_18_REDIS.model.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreateRequest {

    @NotBlank
    private String name;

    private String age;

    private Address address;

    public Person to() {
        return Person.builder()
                .age(this.age)
                .name(this.name)
                .address(this.address)
                .id(UUID.randomUUID().toString())
                .build();
    }

}
