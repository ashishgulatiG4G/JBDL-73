package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.models.Transaction;
import com.example.Class_15_MinorProject.models.TransactionType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {

    // TODO - Will try without query
    @Query("SELECT t FROM Transaction t WHERE t.transaction_student = :student AND t.transaction_book = :book AND t.transactionType = :transactionType ORDER BY t.id DESC limit 1")
    public Transaction findTransactionByStudentBookAndTransactionType(
            @Param("student") Student student,
            @Param("book") Book book,
            @Param("transactionType") TransactionType transactionType);


}
