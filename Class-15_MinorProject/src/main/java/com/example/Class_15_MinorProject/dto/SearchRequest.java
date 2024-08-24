package com.example.Class_15_MinorProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class SearchRequest {

    @NotBlank
    private String searchKey;

    @NotBlank
    private String searchValue;

}


// [genre, "FICTIONAL"]
// [name, "Harry Potter"]
// [id, 1]
// [author_name, ""]


