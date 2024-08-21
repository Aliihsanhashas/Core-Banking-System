package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.dto.AccountDTO;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountByNumber(String accountNumber);

    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO updateAccount(String accountNumber, AccountDTO accountDTO);

    AccountDTO closeAccount(String accountNumber);

    BigDecimal getBalance(String accountNumber);

}
