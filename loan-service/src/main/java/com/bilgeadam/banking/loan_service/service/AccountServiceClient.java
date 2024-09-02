package com.bilgeadam.banking.loan_service.service;

import com.bilgeadam.banking.Account;
import com.bilgeadam.banking.AccountServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceClient {

    private final AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;

    @Autowired
    public AccountServiceClient(AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub) {
        this.accountServiceBlockingStub = accountServiceBlockingStub;
    }

    public String getBalance(String accountNumber) {
        Account.GetBalanceRequest request = Account.GetBalanceRequest.newBuilder()
                .setAccountNumber(accountNumber)
                .build();
        Account.GetBalanceResponse response = accountServiceBlockingStub.getBalance(request);
        return response.getBalance();
    }
}

