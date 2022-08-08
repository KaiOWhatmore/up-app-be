package com.upApp.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TransactionsNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TransactionsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String transactionsNotFoundHandler(TransactionsNotFoundException ex) {
        return ex.getMessage();
    }
}


