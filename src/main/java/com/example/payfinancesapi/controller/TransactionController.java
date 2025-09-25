package com.example.payfinancesapi.controller;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import com.example.payfinancesapi.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionsService transactionsService;

    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/{userId}")
    public Result getTransactions(
            @PathVariable Integer userId) throws Exception {
        return transactionsService.getTransactions(userId);
    }

    @GetMapping("/{userId}/{transactionId}")
    public Result getTransactionsById(
            @PathVariable Integer userId,
            @PathVariable Integer transactionId) throws Exception {
        return transactionsService.getTransactionsById(userId, transactionId);
    }

    @PostMapping
    public Result createTransaction(
            @Valid @RequestBody TransactionRequestDTO req) throws Exception {
        return transactionsService.createTransaction(req);
    }

}
