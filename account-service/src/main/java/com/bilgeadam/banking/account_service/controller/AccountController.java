package com.bilgeadam.banking.account_service.controller;

import com.bilgeadam.banking.account_service.dto.AccountDTO;
import com.bilgeadam.banking.account_service.exception.AccountNotFoundException;
import com.bilgeadam.banking.account_service.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccountByNumber(@PathVariable String accountNumber){
        try {
            AccountDTO accountDTO = accountService.getAccountByNumber(accountNumber);
            return ResponseEntity.ok(accountDTO);
        } catch (AccountNotFoundException e) {
            // Hesap bulunamadığında 404 Not Found yanıtı döndür
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        // DTO'dan domain nesnesine dönüşüm yaparak hesap oluştur
        AccountDTO createdAccount = accountService.createAccount(accountDTO);

        // Oluşturulan hesabı yanıt olarak döndür
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);

    }

}
