package com.bilgeadam.banking.loan_service.entity;

import com.bilgeadam.banking.loan_service.domain.LoanStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "loan")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false)
    private final String accountNumber;

    @Column(name = "loan_amount", nullable = false)
    private final BigDecimal loanAmount;

    @Column(name = "creation_date", nullable = false)
    private final LocalDateTime creationDate;

    @Column(name = "due_date", nullable = false)
    private final LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private final LoanStatus status;

    @Column(name = "interest_rate", nullable = false)
    private final BigDecimal interestRate;

    @Column(name = "remaining_balance", nullable = false)
    private final BigDecimal remainingBalance;

    // Boş constructor (JPA gereği)
    protected LoanEntity() {
        this.id = null;
        this.accountNumber = null;
        this.loanAmount = null;
        this.creationDate = null;
        this.dueDate = null;
        this.status = null;
        this.interestRate = null;
        this.remainingBalance = null;
    }

    // Parametreli constructor
    public LoanEntity(Long id, String accountNumber, BigDecimal loanAmount, LocalDateTime creationDate,
                      LocalDateTime dueDate, LoanStatus status, BigDecimal interestRate,
                      BigDecimal remainingBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.loanAmount = loanAmount;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.status = status;
        this.interestRate = interestRate;
        this.remainingBalance = remainingBalance;
    }

    // Getter metodları
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

    // hashCode metodu
    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, loanAmount, creationDate, dueDate, status, interestRate, remainingBalance);
    }

    // equals metodu
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanEntity that = (LoanEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(loanAmount, that.loanAmount) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(dueDate, that.dueDate) &&
                status == that.status &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(remainingBalance, that.remainingBalance);
    }

    @Override
    public String toString() {
        return "LoanEntity{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", loanAmount=" + loanAmount +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", interestRate=" + interestRate +
                ", remainingBalance=" + remainingBalance +
                '}';
    }
}


