package com.example.payfinancesapi.controller;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import com.example.payfinancesapi.model.Transactions;
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

    @GetMapping
    public Result getTransactions() {
        return transactionsService.getTransactions();
    }

    @GetMapping("/{transactionId}")
    public Result getTransactionsById(@PathVariable String transactionId) throws Exception {
        return transactionsService.getTransactionsById(transactionId);
    }

    @PostMapping
    public Result createTransaction(@RequestBody @Valid TransactionRequestDTO req) throws Exception {
        return transactionsService.createTransaction(req);
    }

}
