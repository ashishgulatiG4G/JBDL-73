package com.example.Class_15_MinorProject.repository;

import com.example.Class_15_MinorProject.models.Book;
import com.example.Class_15_MinorProject.models.Student;
import com.example.Class_15_MinorProject.models.Transaction;
import com.example.Class_15_MinorProject.models.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {

    Transaction findTransactionByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student,
                                                                               Book book,
                                                                               TransactionType transactionType);


}
