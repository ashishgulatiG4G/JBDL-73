package com.example.Class_12_RequestClasses.dto;


import com.example.Class_12_RequestClasses.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserRegistrationRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;


    public User to() {
        return User.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }


}


/*

    -> Request class

            -> Request params
            -> Validation on params


 */



// dto -> model conversion => add a to method to dto class

// model from dto => from method to model class

