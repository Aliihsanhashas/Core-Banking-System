package com.bilgeadam.banking.transaction_service.entity;

import com.bilgeadam.banking.transaction_service.domain.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id  // Primary key oldugunu belirtir veritabanında
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY) // veritabanı için benzersiz bir id değeri atar.
    private Long id;

    @Column(name = "account_id", nullable = false)
    private Long accountId;  // İşlemin ait olduğu hesap kimliği

    @Enumerated(EnumType.STRING) // Değerlerinin veri tabanında string olarak saklanmasını sağlar.
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;  // İşlem türü (DEPOSIT, WITHDRAWAL)

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;  // İşlem miktarı

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;  // İşlem tarihi

    @Column(name = "description", nullable = false)

    private String description;  // İşlem açıklaması

    protected TransactionEntity() {
    }

    public TransactionEntity(Long accountId, TransactionType transactionType, BigDecimal amount,
                             LocalDateTime transactionDate, String description) {
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionEntity that = (TransactionEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountId, that.accountId) &&
                transactionType == that.transactionType &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, transactionType, amount, transactionDate, description);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", description='" + description + '\'' +
                '}';
    }
}
