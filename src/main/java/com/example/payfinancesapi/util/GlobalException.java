package com.example.payfinancesapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationErrors(MethodArgumentNotValidException ex) {
        FieldError fieldError = (FieldError) ex.getBindingResult().getAllErrors().get(0);
        String errorMessage = fieldError.getDefaultMessage();

        Error response = new Error("error", errorMessage);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGenericException(Exception ex) {
        Error response = new Error("error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

