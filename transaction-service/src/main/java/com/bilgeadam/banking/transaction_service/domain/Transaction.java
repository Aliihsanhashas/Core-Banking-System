package com.bilgeadam.banking.transaction_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Transaction {

    private long id;
    private final long accountId;
    private final TransactionType transactionType;
    private final BigDecimal amount;
    private final LocalDateTime transactionDate;
    private final String description;

    private Transaction(TransactionBuilder builder) {
        this.accountId = builder.accountId;
        this.transactionType = builder.transactionType;
        this.amount = builder.amount;
        this.transactionDate = builder.transactionDate;
        this.description = builder.description;
    }

    public long getId() {
        return id;
    }

    public long getAccountId() {
        return accountId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getDescription() {
        return description;
    }

    // static class olmasının sebebi Transaction'dan bağımsız çalışabilsin.
    // TransactionBuilder sınıfının sadece Transaction nesnesi oluşturmak tasarlanıp
    // dış sınıfın iç yapısına erişim sağlamadan, etkilemeden çalışmasını sağlar.
    public static class TransactionBuilder {

        private final long accountId;
        private final TransactionType transactionType;
        private final BigDecimal amount;
        private final LocalDateTime transactionDate;
        private String description;

        public TransactionBuilder(long accountId, TransactionType transactionType, BigDecimal amount,
                                  LocalDateTime transactionDate, String description) {
            this.accountId = accountId;
            this.transactionType = Objects.requireNonNull(transactionType, "Transaction type must not be null");
            this.amount = Objects.requireNonNull(amount, "Amount must not be null");
            this.transactionDate = Objects.requireNonNull(transactionDate, "Transaction date must not be null");
            this.description = Objects.requireNonNull(description, "Description must not be null");
        }

        // Transaction'ın açıklamasını temsil eder. Description değerini ayarlar.
        public TransactionBuilder description(String description) {
            if (description.isBlank()) {
                throw new IllegalArgumentException("Description cannot be blank");
            }
            this.description = description;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
