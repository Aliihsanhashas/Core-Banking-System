package com.bilgeadam.banking.loan_service.dto;

import com.bilgeadam.banking.loan_service.domain.LoanStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanDTO {

    private final String accountNumber;
    private final BigDecimal loanAmount;
    private final LocalDateTime creationDate;
    private final LocalDateTime dueDate;
    private LoanStatus status = LoanStatus.PENDING;
    private final BigDecimal interestRate;
    private BigDecimal remainingBalance;


    public LoanDTO(String accountNumber, BigDecimal loanAmount, LocalDateTime creationDate, LocalDateTime dueDate,
                   BigDecimal interestRate, LoanStatus status, BigDecimal remainingBalance) {
        this.accountNumber = accountNumber;
        this.loanAmount = loanAmount;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.interestRate = interestRate;
        this.status = status;
        this.remainingBalance = remainingBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

}
