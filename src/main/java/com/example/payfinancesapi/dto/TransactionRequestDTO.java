package com.example.payfinancesapi.dto;

import com.example.payfinancesapi.util.ValidationConstants;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.processing.Pattern;
import org.hibernate.validator.constraints.Range;

public class TransactionRequestDTO {

    @NotNull (message = ValidationConstants.userId)
    private Integer userId;

    @NotNull (message = ValidationConstants.amount)
    @Range(min = 0, message = ValidationConstants.amountMin)
    private Double amount;

    @NotNull (message = ValidationConstants.currency)
    private String currency;

    @NotNull (message = ValidationConstants.bankCode)
    private String bankCode;

    @NotNull (message = ValidationConstants.recipientAccountNumber)
    private String recipientAccount;

}
