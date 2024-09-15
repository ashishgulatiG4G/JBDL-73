package com.major.transaction_service.dto;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TransactionCreateRequest {

    @NotBlank
    private String receiverId;

    @Min(1)                     // lowest denomination
    private Long amount;

    private String reason;

}
