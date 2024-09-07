package com.example.Class_15_MinorProject.models;

import com.example.Class_15_MinorProject.dto.BookResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // author
    // this is our foreign key
    @ManyToOne
    @JoinColumn
    private Author author;

     @ManyToOne
     @JoinColumn
     private Student student;


    // Genre -> Enum for genre
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer price;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    //  n number of transactions
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;

    // model -> dto conversion
    public BookResponse to() {
        return BookResponse.builder()
                .id(this.id)
                .name(this.name)
                .student(this.student)
                .author(this.author)
                .genre(this.genre)
                .createdOn(this.createdOn)
                .updatedOn(this.updatedOn)
                .price(this.price)
                .build();
    }




}

//@JoinColumn -> It specified the foreign key column


// Say you need All the books written by an author whose email = xyz@abc.com


//Select * from book where author_name=


// Select * from book where id = (Select id from author where email = xyz@abc.com)

// author.getBookList

