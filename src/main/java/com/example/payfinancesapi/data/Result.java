package com.example.payfinancesapi.data;

import lombok.Data;

@Data
public class Result {

    String status;
    Object data;
    String error_code;
    String error_description;
    String code;
}
