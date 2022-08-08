package com.upApp.demo;

public class TransactionsNotFoundException extends RuntimeException {

    public TransactionsNotFoundException() {
    }

    public TransactionsNotFoundException(String id) {
        super("Could not find transactions" + id);
    }

}
