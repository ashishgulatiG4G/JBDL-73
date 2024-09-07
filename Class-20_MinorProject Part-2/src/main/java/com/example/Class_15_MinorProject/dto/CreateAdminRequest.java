package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Admin;
import com.example.Class_15_MinorProject.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAdminRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public Admin to() {
        return Admin.builder()
                .name(this.name)
                .email(this.email)
                .user(User.builder()
                        .username(this.username)
                        .password(this.password)
                        .build())
                .build();
    }


}
