package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Book;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class GetBookResponse {

    private List<Book> bookList;

    public GetBookResponse from(List<Book> bookList) {
        this.bookList = bookList;
        return this;
    }


}
