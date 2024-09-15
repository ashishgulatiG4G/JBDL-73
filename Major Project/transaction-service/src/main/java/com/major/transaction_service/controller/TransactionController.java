package com.major.transaction_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.major.transaction_service.dto.TransactionCreateRequest;

import com.major.transaction_service.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    /**
     *
     * Initiating the transaction
     */
    @PostMapping("/initiate")
    public String initiateTransaction(@RequestBody @Valid TransactionCreateRequest transactionCreateRequest) throws JsonProcessingException {
        User sender = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return transactionService.transact(transactionCreateRequest, sender.getUsername());

    }




}
