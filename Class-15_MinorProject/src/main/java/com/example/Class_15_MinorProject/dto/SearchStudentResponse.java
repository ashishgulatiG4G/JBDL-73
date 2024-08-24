package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Book;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchStudentResponse {
    private Integer id;

    private String name;
    private String email;

    private String rollNumber;

    private Integer age;

    private Date createdOn;
    private Date updatedOn;

    private List<Book> bookList;

    private String errorMessage;

    public static SearchStudentResponse createErrorResponse(String errorMessage) {
        return SearchStudentResponse.builder()
                .errorMessage(errorMessage)
                .build();
    }


}
