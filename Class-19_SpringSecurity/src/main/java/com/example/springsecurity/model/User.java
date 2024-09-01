package com.example.springsecurity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Getter @Setter String username;
    @Getter @Setter String password;
    @Getter @Setter String roles;
}
