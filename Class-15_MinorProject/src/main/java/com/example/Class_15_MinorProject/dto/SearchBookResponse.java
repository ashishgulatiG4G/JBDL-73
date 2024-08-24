package com.example.Class_15_MinorProject.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchBookResponse {

    List<BookResponse> bookResponses;

}
