package com.example.Class_13_JPA_Hibernate.dao;

import com.example.Class_13_JPA_Hibernate.model.BookLoan;
import com.example.Class_13_JPA_Hibernate.model.BookLoanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanDao extends JpaRepository<BookLoan, BookLoanId> {
}
