package com.example.payfinancesapi.repository;

import com.example.payfinancesapi.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    @Query("select t from Transactions t where t.userId = ?1")
    List<Transactions> findAllTransactionsByUserId(Integer userId);

    @Query("select t from Transactions t where t.userId = ?1 and t.transactionId = ?2")
    Optional<Transactions> findTransactionsByTransactionId(Integer userId, Integer transactionId);

}
