package com.bilgeadam.banking.loan_service.entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "loan")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "loan_number", nullable = false, unique = true)

    private String loanNumber;

    @Column(name = "amount", nullable = false)

    private BigDecimal amount;

    @Column(name = "interest_rate", nullable = false)

    private BigDecimal interestRate;

    @Column(name = "borrower_name", nullable = false)

    private String borrowerName;

    @Column(name = "borrower_contact", nullable = false)

    private String borrowerContact;

    @Column(name = "is_repaid", nullable = false)
    private boolean isRepaid;

    protected LoanEntity() {
    }

    public LoanEntity(String loanNumber, BigDecimal amount, BigDecimal interestRate,
                      String borrowerName, String borrowerContact, boolean isRepaid) {
        this.loanNumber = loanNumber;
        this.amount = amount;
        this.interestRate = interestRate;
        this.borrowerName = borrowerName;
        this.borrowerContact = borrowerContact;
        this.isRepaid = isRepaid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanEntity that = (LoanEntity) o;
        return isRepaid == that.isRepaid &&
                Objects.equals(id, that.id) &&
                Objects.equals(loanNumber, that.loanNumber) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(borrowerName, that.borrowerName) &&
                Objects.equals(borrowerContact, that.borrowerContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loanNumber, amount, interestRate, borrowerName, borrowerContact, isRepaid);
    }

    @Override
    public String toString() {
        return "LoanEntity{" +
                "id=" + id +
                ", loanNumber='" + loanNumber + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", borrowerName='" + borrowerName + '\'' +
                ", borrowerContact='" + borrowerContact + '\'' +
                ", isRepaid=" + isRepaid +
                '}';
    }
}
