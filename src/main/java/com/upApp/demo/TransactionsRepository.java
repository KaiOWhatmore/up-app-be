package com.upApp.demo;

import com.upApp.demo.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, String> {

    Optional<Transactions> findById(String id);

    List<Transactions> findAllByOrderBySettledAt();

    @Query("SELECT " + " new com.upApp.demo.dto.TransactionsCategoryCount(t.category, COUNT(t)) " + " FROM "
            + " Transactions t" + " GROUP BY " + " t.category " + " ORDER BY COUNT(t) DESC")
    List<TransactionsCategoryCount> findTransactionsCategoryCount();

    @Query(value = "SELECT YEAR(settled_at) as year ,MONTH(settled_at) as month ,SUM(amount) as sum "
            + "FROM transactions " + "GROUP BY YEAR(settled_at), MONTH(settled_at) "
            + "ORDER BY YEAR(settled_at), MONTH(settled_at)", nativeQuery = true)
    List<TransactionsNetSpendingPerMonth> getAmountSavedPerMonth();

    @Query(value = "SELECT YEAR(settled_at) AS year ,MONTH(settled_at) AS month , SUM(amount) AS sum"
            + " FROM transactions" + " WHERE amount > 0" + " GROUP BY YEAR(settled_at), MONTH(settled_at)"
            + " ORDER BY YEAR(settled_at), MONTH(settled_at)", nativeQuery = true)
    List<TransactionsIncomePerMonth> getIncomePerMonth();

    @Query(value = "SELECT YEAR(settled_at) AS year ,MONTH(settled_at) AS month , SUM(amount) AS sum"
            + " FROM transactions" + " WHERE amount < 0" + " GROUP BY YEAR(settled_at), MONTH(settled_at)"
            + " ORDER BY YEAR(settled_at), MONTH(settled_at)", nativeQuery = true)
    List<TransactionsExpensesPerMonth> getExpensesPerMonth();

}
