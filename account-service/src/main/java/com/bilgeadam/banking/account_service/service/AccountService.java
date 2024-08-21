package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountByNumber(String accountNumber);

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO updateAccount(AccountDTO accountDTO);

    AccountDTO closeAccount(AccountDTO accountDTO);

}
