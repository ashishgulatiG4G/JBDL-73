package com.example.Class_15_MinorProject.models;

import com.example.Class_15_MinorProject.dto.SearchBookResponse;
import com.example.Class_15_MinorProject.dto.SearchStudentResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    private Integer age;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student")
    private List<Transaction> transactionList;

    public SearchStudentResponse to() {
        return SearchStudentResponse.builder()
                .name(this.name)
                .rollNumber(this.rollNumber)
                .age(this.age)
                .id(this.id)
                .bookList(this.bookList)
                .email(this.email)
                .createdOn(this.createdOn)
                .updatedOn(this.updatedOn)
                .build();
    }


}
