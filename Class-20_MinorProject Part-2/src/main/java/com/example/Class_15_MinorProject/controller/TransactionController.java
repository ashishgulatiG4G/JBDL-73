package com.example.Class_15_MinorProject.controller;

import com.example.Class_15_MinorProject.dto.InitiateTransactionRequest;
import com.example.Class_15_MinorProject.models.Transaction;
import com.example.Class_15_MinorProject.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/initiate")
    public ResponseEntity<String> initiateTxn(@RequestBody @Valid
                              InitiateTransactionRequest initiateTransactionRequest){
        try {
            String transactionId = transactionService.initiateTxn(initiateTransactionRequest);
            return ResponseEntity.ok("TransactionId: " + transactionId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}


// issue/return a book

    // student
    // book
    // txn_type
    // admin


// fine payment