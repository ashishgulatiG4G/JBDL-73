package com.example.Class_13_JPA_Hibernate.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(BookLoanId.class)
public class BookLoan {

    @Id
    private Long borrowerId;
    @Id
    private Long bookId;
    @Id
    private LocalDate loanDate;

    private String remarks;
    private Long charges;
    private Long tenure;



}
