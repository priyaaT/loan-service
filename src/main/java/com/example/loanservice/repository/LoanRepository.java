package com.example.loanservice.repository;

import com.example.loanservice.model.LoanDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<LoanDetails, Integer> {
    @Query("select c from LoanDetails c where c.userId = :userId")
    List<LoanDetails> findLoansbyUserId(@Param("userId") int userId);
}
