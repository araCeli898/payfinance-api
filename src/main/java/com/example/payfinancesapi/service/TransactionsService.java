package com.example.payfinancesapi.service;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TransactionsService {

    Result getTransactions(String userId);

    Result getTransactionsById(UUID transactionId) throws Exception;

    Result createTransaction(TransactionRequestDTO req) throws Exception;

}
