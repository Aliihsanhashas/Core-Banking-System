package com.bilgeadam.banking.account_service.entity;

import com.bilgeadam.banking.account_service.domain.AccountType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id  //Primary key oldugunu belirtir veritabanında
    @GeneratedValue(strategy = GenerationType.IDENTITY) // veritabanı için benzersiz bir id değeri atar.
    private Long id;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Enumerated(EnumType.STRING) //değerlerinin veri tabanında string olarak saklanmasını sağlar.
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;

    @Column(name = "account_holder_contact", nullable = false)
    private String accountHolderContact;

    @Column(name = "is_closed", nullable = false)
    private boolean isClosed;

    protected AccountEntity() {
    }

    public AccountEntity(String accountNumber, AccountType accountType, BigDecimal balance,
                         String accountHolderName, String accountHolderContact, boolean isClosed) {
        this.accountNumber = Objects.requireNonNull(accountNumber, "Account number must not be null");
        this.accountType = Objects.requireNonNull(accountType, "Account type must not be null");
        this.balance = Objects.requireNonNull(balance, "Balance must not be null");
        this.accountHolderName = Objects.requireNonNull(accountHolderName, "Account holder name must not be null");
        this.accountHolderContact = Objects.requireNonNull(accountHolderContact, "Account holder contact must not be null");
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
