package com.upApp.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    Optional<Transactions> findById(String id);

    List<Transactions> findAllByOrderBySettledAt();

    @Query("SELECT " +
            " new com.upApp.demo.TransactionsCategoryCount(t.category, COUNT(t)) " +
            " FROM " +
            " Transactions t" +
            " GROUP BY " +
            " t.category " +
            " ORDER BY COUNT(t) DESC")
    List<TransactionsCategoryCount> findTransactionsCategoryCount();



}
