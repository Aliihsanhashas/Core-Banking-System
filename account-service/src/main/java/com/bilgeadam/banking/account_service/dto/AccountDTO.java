package com.bilgeadam.banking.account_service.dto;

import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.domain.AccountType;

import java.math.BigDecimal;

import java.math.BigDecimal;

public final class AccountDTO {


    private final String accountNumber;
    private final AccountType accountType;
    private final BigDecimal balance;
    private final String accountHolderName;
    private final String accountHolderContact;
    private final boolean isClosed;

    public AccountDTO(String accountNumber, AccountType accountType, BigDecimal balance,
                      String accountHolderName, String accountHolderContact, boolean isClosed) {

        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountHolderContact = accountHolderContact;
        this.isClosed = isClosed;
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

}
