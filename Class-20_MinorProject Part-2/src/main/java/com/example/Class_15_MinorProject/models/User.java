package com.example.Class_15_MinorProject.models;

import com.example.Class_15_MinorProject.utils.Constants;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    private String authorities;

    @OneToOne(mappedBy = "user")
    private Student student;

    @OneToOne(mappedBy = "user")
    private Student admin;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         return Arrays.stream(this.authorities.split(Constants.DELIMITER))
                .map(SimpleGrantedAuthority::new)
                 .toList();
    }
}
