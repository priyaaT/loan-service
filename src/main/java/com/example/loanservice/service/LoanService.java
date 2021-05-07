package com.example.loanservice.service;

import com.example.loanservice.model.LoanDetails;

import java.util.List;

public interface LoanService {
    List<LoanDetails> findByUserId(int userId);

    LoanDetails getUserLoanById(int loanId);

    LoanDetails insert(LoanDetails loanDetails);

}
