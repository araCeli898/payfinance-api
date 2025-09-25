package com.example.payfinancesapi.service;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionsService {

    Result getTransactions(Integer userId) throws Exception;

    Result getTransactionsById(Integer userId, Integer transactionId) throws Exception;

    Result createTransaction(TransactionRequestDTO req) throws Exception;

}
