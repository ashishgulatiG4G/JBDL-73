package com.example.springstarter;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@AllArgsConstructor
@Getter @Setter
@ToString
public class Employee {

    @NotBlank
    private String name;
    @NotNull
    private Integer id;
    @NotNull
    private Integer age;

    //
    //
    //

}

/*

    @NotNull -> element is not null
            but it will not check if a string or collection is empty

    @NotBlank -> ensures that string is Not Null and not empty (after removing whitespace)
                ""
"
 */
