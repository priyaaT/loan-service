package com.example.loanservice.controller;

import com.example.loanservice.model.LoanDetails;
import com.example.loanservice.service.LoanService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loanDetails")
public class LoanController {
    LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/applyLoan")
    public ResponseEntity<LoanDetails> saveLoanDetails(@Valid @RequestBody LoanDetails loanDetails) {
        LoanDetails loanDetails1 = loanService.insert(loanDetails);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("personalDetails", "/api/v1/personalDetails/");
        return new ResponseEntity<>(loanDetails1, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/viewLoans/{userId}")
    public ResponseEntity<List<LoanDetails>> loginCustomer(@PathVariable int userId) {
        List<LoanDetails> loanDetails = loanService.findByUserId(userId);
        if (loanDetails != null) {
            return new ResponseEntity<>(loanDetails, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
