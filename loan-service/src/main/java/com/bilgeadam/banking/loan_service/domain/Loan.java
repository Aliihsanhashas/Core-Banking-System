package com.bilgeadam.banking.loan_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Loan {

    private final Long id;  // ID alanı final, veritabanı tarafından atanacak
    private final String accountNumber;
    private final BigDecimal loanAmount;
    private final LocalDateTime creationDate;
    private final LocalDateTime dueDate;
    private final LoanStatus status;
    private final BigDecimal interestRate;
    private final BigDecimal remainingBalance;

    private Loan(LoanBuilder builder) {
        this.id = builder.id; // ID alanı veritabanından okunacak şekilde koruyoruz
        this.accountNumber = builder.accountNumber;
        this.loanAmount = builder.loanAmount;
        this.creationDate = builder.creationDate;
        this.dueDate = builder.dueDate;
        this.status = builder.status;
        this.interestRate = builder.interestRate;
        this.remainingBalance = builder.remainingBalance;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getRemainingBalance() {
        return remainingBalance;
    }

    public static class LoanBuilder {

        private Long id; // ID alanı isteğe bağlı olarak ayarlanabilir, ancak veritabanı tarafından atanır
        private final String accountNumber;
        private final BigDecimal loanAmount;
        private final LocalDateTime creationDate;
        private final LocalDateTime dueDate;
        private LoanStatus status = LoanStatus.PENDING; // Default status
        private final BigDecimal interestRate;
        private BigDecimal remainingBalance;

        public LoanBuilder(String accountNumber, BigDecimal loanAmount, LocalDateTime creationDate,
                           LocalDateTime dueDate, BigDecimal interestRate) {
            this.accountNumber = Objects.requireNonNull(accountNumber, "Account number must not be null");
            this.loanAmount = Objects.requireNonNull(loanAmount, "Loan amount must not be null");
            this.creationDate = Objects.requireNonNull(creationDate, "Creation date must not be null");
            this.dueDate = Objects.requireNonNull(dueDate, "Due date must not be null");
            this.interestRate = Objects.requireNonNull(interestRate, "Interest rate must not be null");
            this.remainingBalance = loanAmount; // Initial remaining balance is the loan amount
        }

        public LoanBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public LoanBuilder status(LoanStatus status) {
            this.status = status;
            return this;
        }

        public LoanBuilder remainingBalance(BigDecimal remainingBalance) {
            this.remainingBalance = remainingBalance;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }
    }
}

