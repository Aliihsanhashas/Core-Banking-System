package com.bilgeadam.banking.account_service.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Account {

    private Long id;
    private final String accountNumber;
    private final AccountType accountType;
    private final BigDecimal balance;
    private final String accountHolderName;
    private final String accountHolderContact;
    private final boolean isClosed;

    private Account(AccountBuilder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.accountHolderName = builder.accountHolderName;
        this.accountHolderContact = builder.accountHolderContact;
        this.isClosed = builder.isClosed;
    }

    public long getId() {
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

    // static class olmasının sebebi account dan bağımsız çalışabilsin.
    //AccountBuilder sınıfının sadece Account nesnesi oluşturmak tasarlanıp
    //dış sınıfın iç yapısına erişim sağlamadan,etkilemeden çalışmasını sağlar.
    public static class AccountBuilder {

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

        //Account'un bakiye bilgisini temsil eder. balance değerini ayarlar.Ve kontrol eder.
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
