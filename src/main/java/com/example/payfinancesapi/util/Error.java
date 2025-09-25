package com.example.payfinancesapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String status;
    private String errorMessage;
}