package com.example.loanservice.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(Integer id) {
        super(String.format("No Loans Found", id));
    }
}
