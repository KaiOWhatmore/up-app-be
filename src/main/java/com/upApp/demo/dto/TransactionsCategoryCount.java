package com.upApp.demo.dto;

import lombok.Data;

@Data
public class TransactionsCategoryCount {

    private String category;
    private Long count;

    public TransactionsCategoryCount(String category, Long count) {
        this.category = category;
        this.count = count;
    }
}
