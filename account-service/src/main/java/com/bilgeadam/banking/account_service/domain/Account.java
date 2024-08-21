package com.bilgeadam.banking.account_service.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Account {

    private final Long id;  // ID alanı final ancak, veritabanı tarafından atanacak
    private final String accountNumber;
    private final AccountType accountType;
    private final BigDecimal balance;
    private final String accountHolderName;
    private final String accountHolderContact;
    private final boolean isClosed;

    private Account(AccountBuilder builder) {
        this.id = builder.id; // ID alanını veritabanından okunacak şekilde koruyoruz
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.accountHolderName = builder.accountHolderName;
        this.accountHolderContact = builder.accountHolderContact;
        this.isClosed = builder.isClosed;
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

    public static class AccountBuilder {

        private Long id; // ID alanı isteğe bağlı olarak ayarlanabilir, ancak veritabanı tarafından atanır
        private final String accountNumber;
        private final AccountType accountType;
        private BigDecimal balance = BigDecimal.ZERO;
        private final String accountHolderName;
        private final String accountHolderContact;
        private boolean isClosed = false;   //default value.

        public AccountBuilder(String accountNumber, AccountType accountType, String accountHolderName,
                              String accountHolderContact) {
            this.accountNumber = Objects.requireNonNull(accountNumber, "Account number must not be null");
            this.accountType = Objects.requireNonNull(accountType, "Account type must not be null");
            this.accountHolderName = Objects.requireNonNull(accountHolderName, "Account holder name must not be null");
            this.accountHolderContact = Objects.requireNonNull(accountHolderContact, "Account holder contact must not be null");
        }

        // ID'yi ayarlamaya gerek kalmadan veritabanından okuma imkanı tanır.
        public AccountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public AccountBuilder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder isClosed(boolean isClosed) {
            this.isClosed = isClosed;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
