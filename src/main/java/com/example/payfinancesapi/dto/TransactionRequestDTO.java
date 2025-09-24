package com.example.payfinancesapi.dto;

import com.example.payfinancesapi.model.Currency;
import com.example.payfinancesapi.util.Constants;
import com.example.payfinancesapi.util.ValidationConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

public class TransactionRequestDTO {

    @NotNull (message = ValidationConstants.userId)
    private Integer userId;

    @NotNull (message = ValidationConstants.amount)
    @Range(min = 1, message = ValidationConstants.amountMin)
    private Double amount;

    @NotNull(message = ValidationConstants.currency)
    private Currency currency;

    @Pattern(regexp = Constants.bankCode, message = ValidationConstants.bankCodeRegexp )
    @NotNull (message = ValidationConstants.bankCode)
    private String bankCode;

    @Pattern(regexp = Constants.recipientAccount, message = ValidationConstants.recipientAccountRegexp )
    @NotNull (message = ValidationConstants.recipientAccount)
    private String recipientAccount;

}
