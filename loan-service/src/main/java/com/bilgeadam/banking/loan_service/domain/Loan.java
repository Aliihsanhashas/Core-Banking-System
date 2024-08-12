package com.bilgeadam.banking.loan_service.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Loan {

    private long id;
    private final String loanNumber;
    private final BigDecimal amount;
    private final BigDecimal interestRate;
    private final String borrowerName;
    private final String borrowerContact;
    private final boolean isRepaid;

    private Loan(LoanBuilder builder) {
        this.loanNumber = builder.loanNumber;
        this.amount = builder.amount;
        this.interestRate = builder.interestRate;
        this.borrowerName = builder.borrowerName;
        this.borrowerContact = builder.borrowerContact;
        this.isRepaid = builder.isRepaid;
    }

    public long getId() {
        return id;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowerContact() {
        return borrowerContact;
    }

    public boolean isRepaid() {
        return isRepaid;
    }

    public static class LoanBuilder {

        private final String loanNumber;
        private final BigDecimal amount;
        private final BigDecimal interestRate;
        private final String borrowerName;
        private final String borrowerContact;
        private boolean isRepaid = false; // default value.

        public LoanBuilder(String loanNumber, BigDecimal amount, BigDecimal interestRate,
                           String borrowerName, String borrowerContact) {
            this.loanNumber = Objects.requireNonNull(loanNumber, "Loan number must not be null");
            this.amount = Objects.requireNonNull(amount, "Amount must not be null");
            this.interestRate = Objects.requireNonNull(interestRate, "Interest rate must not be null");
            this.borrowerName = Objects.requireNonNull(borrowerName, "Borrower name must not be null");
            this.borrowerContact = Objects.requireNonNull(borrowerContact, "Borrower contact must not be null");
        }

        public LoanBuilder isRepaid(boolean isRepaid) {
            this.isRepaid = isRepaid;
            return this;
        }

        public Loan build() {
            return new Loan(this);
        }
    }
}


