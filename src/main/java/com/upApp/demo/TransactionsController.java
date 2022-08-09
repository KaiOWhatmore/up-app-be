package com.upApp.demo;

import com.upApp.demo.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @GetMapping
    List<Transactions> findAll() {
        return transactionsService.findAll();
    }

    @GetMapping("/{id}")
    Transactions findById(@PathVariable String id) {
        return transactionsService.findById(id);
    }

    @GetMapping("/categories")
    List<TransactionsCategoryCount> findCategoryCount() {
        return transactionsService.findCategoryCount();
    }

    @GetMapping("/monthly-savings")
    List<TransactionsNetSpendingPerMonth> getAmountSavedPerMonth() {
        return transactionsService.getAmountSavedPerMonth();
    }

    @GetMapping("/monthly-income")
    List<TransactionsIncomePerMonth> getIncomePerMonth() {
        return transactionsService.getIncomePerMonth();
    }

    @GetMapping("/monthly-expenses")
    List<TransactionsExpensesPerMonth> getExpensesPerMonth() {
        return transactionsService.getExpensesPerMonth();
    }
}
