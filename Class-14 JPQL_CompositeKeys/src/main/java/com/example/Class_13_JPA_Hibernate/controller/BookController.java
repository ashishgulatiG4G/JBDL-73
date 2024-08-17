package com.example.Class_13_JPA_Hibernate.controller;

import com.example.Class_13_JPA_Hibernate.dao.BookLoanDao;
import com.example.Class_13_JPA_Hibernate.model.BookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class BookController {

    @Autowired
    BookLoanDao bookLoanDao;

    @PostMapping("/book")
    public ResponseEntity<String> saveBook() {

        LocalDate localDate = LocalDate.EPOCH;

        BookLoan bookLoan = BookLoan.builder()
                .bookId(1L)
                .borrowerId(100L)
                .loanDate(null)
                .build();

        bookLoanDao.save(bookLoan);

        return ResponseEntity.ok("Book loan created");


    }


}
