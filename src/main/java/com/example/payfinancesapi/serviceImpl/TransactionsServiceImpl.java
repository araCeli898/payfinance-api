package com.example.payfinancesapi.serviceImpl;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import com.example.payfinancesapi.repository.TransactionsRepository;
import com.example.payfinancesapi.service.TransactionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;


    @Override
    public Result getTransactions() {
        return null;
    }

    @Override
    public Result getTransactionsById(String id) {
        return null;
    }

    @Override
    public Result createTransaction(TransactionRequestDTO req) {
        return null;
    }
}
