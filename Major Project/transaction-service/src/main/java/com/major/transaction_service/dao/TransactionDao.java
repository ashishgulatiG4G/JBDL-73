package com.major.transaction_service.dao;

import com.major.transaction_service.models.Transaction;
import com.major.transaction_service.models.TransactionStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Integer> {

    @Transactional
    @Modifying
    @Query("update Transaction t set t.transactionStatus = ?1 where t.externalTransactionId = ?2")
    void updateTransaction(TransactionStatus transactionStatus, String externalTransactionId);

}
