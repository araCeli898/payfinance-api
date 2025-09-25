package com.example.payfinancesapi.model;

import com.example.payfinancesapi.modelEnum.BankCode;
import com.example.payfinancesapi.modelEnum.ValidationTransactionStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
public class Transactions {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID transactionId;

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
