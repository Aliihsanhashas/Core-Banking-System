package com.bilgeadam.banking.transaction_service.entity;

import com.bilgeadam.banking.transaction_service.domain.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String fromAccount;

    @Column(nullable = false)
    private String toAccount;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    // Constructors, Getters, and Setters

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, String transactionNumber, TransactionType transactionType, BigDecimal amount,
                             String fromAccount, String toAccount, LocalDateTime transactionDate) {
        this.id = id;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionNumber, that.transactionNumber) &&
                transactionType == that.transactionType &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(fromAccount, that.fromAccount) &&
                Objects.equals(toAccount, that.toAccount) &&
                Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionNumber, transactionType, amount, fromAccount, toAccount, transactionDate);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", transactionNumber='" + transactionNumber + '\'' +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", fromAccount='" + fromAccount + '\'' +
                ", toAccount='" + toAccount + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
