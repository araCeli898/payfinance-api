package com.example.payfinancesapi.repository;

import com.example.payfinancesapi.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    @Query("select t from Transactions t where t.userId = ?1")
    List<Transactions> findAllTransactionsByUserId(String userId);

    @Query("select t from Transactions t where t.transactionId = ?1")
    Optional<Transactions> findTransactionsByTransactionId(UUID transactionId);

}
