package com.bilgeadam.banking.loan_service.entity;

import com.bilgeadam.banking.loan_service.domain.LoanStatus;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "loan")
public class LoanEntity {

    @Id  //Primary key olarak belirtilir
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Veritabanı için benzersiz bir id değeri atar
    private Long id;

    @Column(name = "loan_number", nullable = false, unique = true)
    @NotBlank
    private String loanNumber;

    @Column(name = "amount", nullable = false)
    @NotNull
    private BigDecimal amount;

    @Column(name = "balance", nullable = false)
    @NotNull
    private BigDecimal balance;

    @Column(name = "account_holder_name", nullable = false)
    @NotBlank
    private String accountHolderName;

    @Column(name = "start_date", nullable = false)
    @NotNull
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING) // Enum değerlerinin veritabanında string olarak saklanmasını sağlar
    @Column(name = "status", nullable = false)
    @NotNull
    private LoanStatus status;

    protected LoanEntity() {
    }

    public LoanEntity(String loanNumber, BigDecimal amount, BigDecimal balance, String accountHolderName,
                      LocalDateTime startDate, LocalDateTime endDate, LoanStatus status) {
        this.loanNumber = loanNumber;
        this.amount = amount;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanEntity that = (LoanEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(loanNumber, that.loanNumber) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(accountHolderName, that.accountHolderName) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanNumber, amount, balance, accountHolderName, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return "LoanEntity{" +
                "id=" + id +
                ", loanNumber='" + loanNumber + '\'' +
                ", amount=" + amount +
                ", balance=" + balance +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }
}
