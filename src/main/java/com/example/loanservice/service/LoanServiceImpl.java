package com.example.loanservice.service;

import com.example.loanservice.exception.LoanNotFoundException;
import com.example.loanservice.model.LoanDetails;
import com.example.loanservice.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    LoanRepository loanRepository;

    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public List<LoanDetails> findByUserId(int userId) {

        List<LoanDetails> loanDetailsForUser = loanRepository.findLoansbyUserId(userId);
        if(loanDetailsForUser.isEmpty()){
            throw new LoanNotFoundException(userId);
        }
        return loanDetailsForUser;
    }

    @Override
    public LoanDetails getUserLoanById(int loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new LoanNotFoundException(loanId));
    }

    @Override
    public LoanDetails insert(LoanDetails loanDetails) {
        return loanRepository.save(loanDetails);
    }
}