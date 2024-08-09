package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



}
