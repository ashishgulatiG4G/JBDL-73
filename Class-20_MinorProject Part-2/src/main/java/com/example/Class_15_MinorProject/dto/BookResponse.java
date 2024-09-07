package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.Author;
import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Genre;
import com.example.Class_15_MinorProject.models.Student;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class BookResponse {

    private Integer id;

    private String name;

    private Author book_author;

    private Student book_student;

    private Genre genre;

    private Integer price;

    private Date createdOn;

    private Date updatedOn;

}
