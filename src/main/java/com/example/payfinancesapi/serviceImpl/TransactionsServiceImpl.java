package com.example.payfinancesapi.serviceImpl;

import com.example.payfinancesapi.data.Result;
import com.example.payfinancesapi.dto.TransactionDTO;
import com.example.payfinancesapi.dto.TransactionRequestDTO;
import com.example.payfinancesapi.model.Transactions;
import com.example.payfinancesapi.repository.TransactionsRepository;
import com.example.payfinancesapi.service.TransactionsService;
import com.example.payfinancesapi.util.Constants;
import com.example.payfinancesapi.util.RandomStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Constant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public Result getTransactions(Integer userId) {
        log.info("Finding transactions by userId {}", userId);
        List<Transactions> transactions = transactionsRepository.findTransactionsByUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionDTO> transactionDTOS = Arrays.asList(modelMapper.map(transactions, TransactionDTO[].class));
        return new Result(Constants.RESULT_OK, transactionDTOS);
    }

    @Override
    public Result getTransactionsById(String transactionId) throws Exception {
        log.info("Finding transactions by transactionId {}", transactionId);
        Transactions transaction = findTransactionById(transactionId);
        return new Result(Constants.RESULT_OK, new ModelMapper().map(transaction, TransactionDTO[].class));
    }

    @Override
    public Result createTransaction(TransactionRequestDTO req) throws Exception {
        Transactions transaction = new ModelMapper().map(req, Transactions.class);
        transaction.setStatus(RandomStatus.getRandomStatus());
        try {
            log.info("Creating transaction, userId {}", transaction.getUserId());
            transactionsRepository.save(transaction);
        } catch (Exception e) {
            log.error("Error creating transaction, userId {}", transaction.getUserId(), e);
            throw new Exception("Error creating transaction, userId " + transaction.getUserId());
        }
        return new Result(Constants.RESULT_OK, transaction);
    }

    private Transactions findTransactionById (String transactionId) throws Exception {
        return transactionsRepository.findTransactionsByTransactionId(transactionId)
                .orElseThrow(() -> {
                    log.warn("Finding transaction by transactionId {}", transactionId);
                    return new Exception("Transaction not found");
                });
    }
}
