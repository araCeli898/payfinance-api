package com.example.payfinancesapi.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TransactionDTO {

    private UUID transactionId;
    private Integer userId;
    private String recipientAccount;
    private Double amount;
    private String currency;
    private String status;
    private String createdAt;
    private String bankCode;

}
