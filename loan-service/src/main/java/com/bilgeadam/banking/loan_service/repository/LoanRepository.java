package com.bilgeadam.banking.loan_service.repository;

import com.bilgeadam.banking.loan_service.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
