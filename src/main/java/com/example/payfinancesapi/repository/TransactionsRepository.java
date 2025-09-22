package com.example.payfinancesapi.repository;

import com.example.payfinancesapi.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

    @Query("select t from Transactions t where t.userId = ?1")
    List<Transactions> findTransactionsByUserId();

    @Query("select t from Transactions t where t.userId = ?1 and t.transactionId = ?2")
    List<Transactions> findTransactionsByUserIdAndTransactionId(String userId, String transactionId);

}
