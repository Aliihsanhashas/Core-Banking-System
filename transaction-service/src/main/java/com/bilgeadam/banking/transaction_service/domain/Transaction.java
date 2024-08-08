package com.bilgeadam.banking.transaction_service.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Transaction {

    private final String transactionId;

    private final String sourceAccountNumber;

    private final String destinationAccountNumber;

    private final BigDecimal amount;

    private final LocalDateTime timestamp;

    private final TransactionType transactionType;



    // Builder kullanılarak Transaction nesnesinin oluşturulması
    private Transaction(TransactionBuilder builder) {
        this.transactionId = builder.transactionId;
        this.sourceAccountNumber = builder.sourceAccountNumber;
        this.destinationAccountNumber = builder.destinationAccountNumber;
        this.amount = builder.amount;
        this.timestamp = builder.timestamp;
        this.transactionType = builder.transactionType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    // Transaction nesnesini oluşturmak için Builder sınıfı
    public static class TransactionBuilder {
        // Builder sınıfında kullanılacak tüm özellikler
        private final String transactionId;
        private final String sourceAccountNumber;
        private final String destinationAccountNumber;
        private final BigDecimal amount;
        private final LocalDateTime timestamp;
        private final TransactionType transactionType;

        // Builder'ın gerekli tüm parametrelerle başlatılması
        public TransactionBuilder(String transactionId, String sourceAccountNumber, String destinationAccountNumber,
                                  BigDecimal amount, LocalDateTime timestamp, TransactionType transactionType) {
            this.transactionId = Objects.requireNonNull(transactionId, "Transaction ID must not be null");
            this.sourceAccountNumber = Objects.requireNonNull(sourceAccountNumber, "Source account number must not be null");
            this.destinationAccountNumber = Objects.requireNonNull(destinationAccountNumber, "Destination account number must not be null");
            this.amount = Objects.requireNonNull(amount, "Amount must not be null");
            this.timestamp = Objects.requireNonNull(timestamp, "Timestamp must not be null");
            this.transactionType = Objects.requireNonNull(transactionType, "Transaction type must not be null");
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
