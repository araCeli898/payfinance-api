package com.example.payfinancesapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String bankCode;
}
