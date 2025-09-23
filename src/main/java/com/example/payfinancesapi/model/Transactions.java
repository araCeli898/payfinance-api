package com.example.payfinancesapi.model;

import com.example.payfinancesapi.util.ValidationTransactionStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue
    private String transactionId;

    private int userId;

    private String recipientAccount;

    private BigDecimal amount;

    private String currency;

    @Enumerated(EnumType.STRING)
    private ValidationTransactionStatus status;

    private LocalDateTime createdAt;

    private String bankCode;

}
