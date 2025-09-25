package com.example.payfinancesapi.model;

import com.example.payfinancesapi.modelEnum.BankCode;
import com.example.payfinancesapi.modelEnum.ValidationTransactionStatus;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    private Integer userId;

    private String recipientAccount;

    private BigDecimal amount;

    private String currency;

    private ValidationTransactionStatus status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    private String bankCode;
}
