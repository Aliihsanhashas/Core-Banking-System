package com.bilgeadam.banking.loan_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Loan {

    private final Long id;
    private final String loanNumber;
    private final BigDecimal amount;
    private final BigDecimal balance;
    private final String accountHolderName;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final LoanStatus status;

    private Loan(Builder builder) {
        this.id = builder.id;
        this.loanNumber = builder.loanNumber;
        this.amount = builder.amount;
        this.balance = builder.balance;
        this.accountHolderName = builder.accountHolderName;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.status = builder.status;
    }

    public static class Builder {
        private Long id;
        private String loanNumber;
        private BigDecimal amount;
        private BigDecimal balance;
        private String accountHolderName;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private LoanStatus status;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withLoanNumber(String loanNumber) {
            this.loanNumber = loanNumber;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder withBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Builder withAccountHolderName(String accountHolderName) {
            this.accountHolderName = accountHolderName;
            return this;
        }

        public Builder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withStatus(LoanStatus status) {
            this.status = status;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }
    }

    // Getters for the fields

    public Long getId() {
        return id;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public LoanStatus getStatus() {
        return status;
    }
}

