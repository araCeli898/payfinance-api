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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public Result getTransactions(Integer userId) throws Exception {
        log.info("Buscando transacciones");
        List<Transactions> transactions;
        try {
            transactions = findTransactionsByUserId(userId);;
        } catch (Exception e) {
            log.warn("No se encontraron transacciones para el usuario {}", userId);
            throw new Exception("Usuario no encontrado o sin transacciones, userId " + userId);
        }
        ModelMapper modelMapper = new ModelMapper();
        List<TransactionDTO> transactionDTOS = Arrays.asList(modelMapper.map(transactions, TransactionDTO[].class));
        return new Result(Constants.RESULT_OK, transactionDTOS);
    }

    @Override
    public Result getTransactionsById(Integer userId,Integer transactionId) throws Exception {
        log.info("Buscando transacciones para transactionId {}", transactionId);
        Transactions transaction = findTransactionById(userId, transactionId);
        return new Result(Constants.RESULT_OK, new ModelMapper().map(transaction, TransactionDTO.class));
    }

    @Override
    public Result createTransaction(TransactionRequestDTO req) throws Exception {
        ModelMapper mapper = new ModelMapper();
        mapper.typeMap(TransactionRequestDTO.class, Transactions.class)
                .addMappings(m -> m.skip(Transactions::setTransactionId));

        Transactions transaction = mapper.map(req, Transactions.class);
        transaction.setStatus(RandomStatus.getRandomStatus());
        Transactions savedTransaction;
        try {
            log.info("Creando transacción, userId {}", transaction.getUserId());
            savedTransaction = transactionsRepository.save(transaction);
        } catch (Exception e) {
            log.error("Error al crear transacción, userId {}", transaction.getUserId(), e);
            throw new Exception("Error al crear transacción, userId " + transaction.getUserId());
        }
        return new Result(Constants.RESULT_OK, new ModelMapper().map(savedTransaction, TransactionDTO.class));
    }

    private Transactions findTransactionById (Integer userId, Integer transactionId) throws Exception {
        return transactionsRepository.findTransactionsByTransactionId(userId, transactionId)
                .orElseThrow(() -> {
                    log.warn("No se encontraron transacciones para el userId {} y el transactionId {} ", userId, transactionId);
                    return new Exception("La transacción o el usuario no existe");
                });
    }

    private List<Transactions> findTransactionsByUserId(Integer userId) throws Exception {
        List<Transactions> transactions = transactionsRepository.findAllTransactionsByUserId(userId);

        if (transactions.isEmpty()) {
            log.warn("No se encontraron transacciones para el userId {}", userId);
            throw new Exception("Usuario no encontrado o sin transacciones");
        }

        return transactions;
    }

}
