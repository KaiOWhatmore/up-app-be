package com.upApp.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Transactional(readOnly = true)
    public List<Transactions> findAll() {
        return transactionsRepository.findAllByOrderBySettledAt();
    }

    public Transactions findById(String id) {
        return transactionsRepository.findById(id).orElseThrow(() -> new TransactionsNotFoundException(id));
    }

    public List<TransactionsCategoryCount> findCategoryCount() {
        return transactionsRepository.findTransactionsCategoryCount();
    }




}
