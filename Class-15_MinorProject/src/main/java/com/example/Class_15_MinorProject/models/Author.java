package com.example.Class_15_MinorProject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false)
    @Getter
    private String email;

    @CreationTimestamp
    private Date createdOn;

    // n books here
    // What type of relationship it is
    // List<Book>

    @OneToMany(mappedBy = "book_author")
    private List<Book> bookList;


}
