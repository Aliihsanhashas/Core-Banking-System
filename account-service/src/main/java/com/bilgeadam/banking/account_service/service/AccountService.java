package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    //Tüm hesapları DB den çeker.
    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountByNumber(String accountNumber);

    //DB ye veri ekleme.
    AccountDTO createAccount(AccountDTO accountDTO);
}
