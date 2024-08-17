package com.example.Class_13_JPA_Hibernate.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class BookLoanId implements Serializable {

    private Long borrowerId;
    private Long bookId;
    private LocalDate loanDate;

}
