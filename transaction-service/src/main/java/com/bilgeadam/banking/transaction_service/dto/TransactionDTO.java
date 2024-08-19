package com.bilgeadam.banking.transaction_service.dto;

import com.bilgeadam.banking.transaction_service.domain.Transaction;
import com.bilgeadam.banking.transaction_service.domain.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class TransactionDTO {

    private final long id;
    private final String transactionNumber;
    private final TransactionType transactionType;
    private final BigDecimal amount;
    private final String fromAccount;
    private final String toAccount;
    private final LocalDateTime transactionDate;

    public TransactionDTO(long id, String transactionNumber, TransactionType transactionType, BigDecimal amount,
                          String fromAccount, String toAccount, LocalDateTime transactionDate) {
        this.id = id;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionDate = transactionDate;
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

    // Transaction domain nesnesinden TransactionDTO oluşturma
    public static TransactionDTO fromDomain(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getTransactionNumber(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getFromAccount(),
                transaction.getToAccount(),
                transaction.getTransactionDate()
        );
    }

    // TransactionDTO'dan Transaction domain nesnesi oluşturma
    public Transaction toDomain() {
        return new Transaction.TransactionBuilder(id, transactionNumber, transactionType, amount)
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .transactionDate(transactionDate)
                .build();
    }
}
