package com.example.Class_15_MinorProject.dto;

import com.example.Class_15_MinorProject.models.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InitiateTransactionRequest {

    @NotNull
    private String studentRollNumber;
    @NotNull
    private Integer bookId;
    @NotNull
    private Integer adminId;
    @NotNull
    private TransactionType transactionType;





}
