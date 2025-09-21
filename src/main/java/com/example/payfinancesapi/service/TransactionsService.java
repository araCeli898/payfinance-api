package com.example.payfinancesapi.service;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionsService {

    Result getTransactions();

    Result getTransactionsById(String id);

    Result createTransaction(TransactionRequestDTO req);

}
