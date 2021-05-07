package com.example.loanservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDetails {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    int loanId;
    @Column
    @NotNull(message = "UserId cannot be null")
    int userId;
    @Column
    LoanType loanType;
    @Column
    @NotNull(message = "LoanAmount cannot be null")
    float loanAmount;
    @Column
    @CreationTimestamp
    LocalDate date;
    @Column
    double rateOfInterest;
    @Column
    float durationOfLoan;
}
