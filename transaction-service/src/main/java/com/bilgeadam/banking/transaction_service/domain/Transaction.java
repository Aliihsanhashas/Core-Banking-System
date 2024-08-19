package com.bilgeadam.banking.transaction_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Transaction {

    private final long id;
    private final String transactionNumber;
    private final TransactionType transactionType;
    private final BigDecimal amount;
    private final String fromAccount;
    private final String toAccount;
    private final LocalDateTime transactionDate;

    private Transaction(TransactionBuilder builder) {
        this.id = builder.id;
        this.transactionNumber = builder.transactionNumber;
        this.transactionType = builder.transactionType;
        this.amount = builder.amount;
        this.fromAccount = builder.fromAccount;
        this.toAccount = builder.toAccount;
        this.transactionDate = builder.transactionDate;
    }

    public long getId() {
        return id;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public static class TransactionBuilder {
        private final long id;
        private final String transactionNumber;
        private final TransactionType transactionType;
        private final BigDecimal amount;
        private String fromAccount;
        private String toAccount;
        private LocalDateTime transactionDate = LocalDateTime.now();

        public TransactionBuilder(long id, String transactionNumber, TransactionType transactionType, BigDecimal amount) {
            this.id = id;
            this.transactionNumber = Objects.requireNonNull(transactionNumber, "Transaction number must not be null");
            this.transactionType = Objects.requireNonNull(transactionType, "Transaction type must not be null");
            this.amount = Objects.requireNonNull(amount, "Amount must not be null");
        }

        public TransactionBuilder fromAccount(String fromAccount) {
            this.fromAccount = Objects.requireNonNull(fromAccount, "From account must not be null");
            return this;
        }

        public TransactionBuilder toAccount(String toAccount) {
            this.toAccount = Objects.requireNonNull(toAccount, "To account must not be null");
            return this;
        }

        public TransactionBuilder transactionDate(LocalDateTime transactionDate) {
            this.transactionDate = Objects.requireNonNull(transactionDate, "Transaction date must not be null");
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
