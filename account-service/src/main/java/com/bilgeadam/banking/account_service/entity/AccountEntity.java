package com.bilgeadam.banking.account_service.entity;

import com.bilgeadam.banking.account_service.domain.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id  //Primary key oldugunu belirtir veritabanında
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY) // veritabanı için benzersiz bir id değeri atar.
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    @NotBlank
    private String accountNumber;

    @Enumerated(EnumType.STRING) //değerlerinin veri tabanında string olarak saklanmasını sağlar.
    @Column(name = "account_type", nullable = false)
    @NotNull
    private AccountType accountType;

    @Column(name = "balance", nullable = false)
    @NotNull
    private BigDecimal balance;

    @Column(name = "account_holder_name", nullable = false)
    @NotBlank
    private String accountHolderName;

    @Column(name = "account_holder_contact", nullable = false)
    @NotBlank
    private String accountHolderContact;

    @Column(name = "is_closed", nullable = false)
    private boolean isClosed;

    protected AccountEntity() {
    }

    public AccountEntity(String accountNumber, AccountType accountType, BigDecimal balance,
                         String accountHolderName, String accountHolderContact, boolean isClosed) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountHolderContact = accountHolderContact;
        this.isClosed = isClosed;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountHolderContact() {
        return accountHolderContact;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return isClosed == that.isClosed &&
                Objects.equals(id, that.id) &&
                Objects.equals(accountNumber, that.accountNumber) &&
                accountType == that.accountType &&
                Objects.equals(balance, that.balance) &&
                Objects.equals(accountHolderName, that.accountHolderName) &&
                Objects.equals(accountHolderContact, that.accountHolderContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, accountType, balance, accountHolderName, accountHolderContact, isClosed);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType=" + accountType +
                ", balance=" + balance +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountHolderContact='" + accountHolderContact + '\'' +
                ", isClosed=" + isClosed +
                '}';
    }
}