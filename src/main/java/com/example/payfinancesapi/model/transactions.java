package com.example.payfinancesapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
public class transactions {

    @Id
    @GeneratedValue
    private UUID id;

    private int userId;

    private String recipientAccount;

    private BigDecimal amount;

    private String currency;

    private String status;

    private LocalDateTime createdAt;

    private String bankCode;

}
