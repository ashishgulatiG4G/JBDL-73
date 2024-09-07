package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Author;
import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {

    @NotBlank
    private String name;
    @NotNull
    private Genre genre;
    @NotBlank
    private String authorName;
    @NotBlank
    private String authorEmail;
    private Integer price;

    public Book to() {
        Author author = Author.builder()
                .name(this.authorName)
                .email(this.authorEmail)
                .build();

        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .author(author)
                .build();
    }




}
