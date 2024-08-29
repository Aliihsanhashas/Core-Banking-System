package com.bilgeadam.banking.loan_service.controller;

import com.bilgeadam.banking.loan_service.dto.LoanDTO;
import com.bilgeadam.banking.loan_service.exception.LoanNotFoundException;
import com.bilgeadam.banking.loan_service.service.AccountServiceClient;
import com.bilgeadam.banking.loan_service.service.LoanServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/loan")
public class LoanController {
    private final LoanServiceImpl loanServiceImpl;
    private final AccountServiceClient accountServiceClient;

    public LoanController(LoanServiceImpl loanServiceImpl, AccountServiceClient accountServiceClient) {
        this.loanServiceImpl = loanServiceImpl;
        this.accountServiceClient = accountServiceClient;
    }
    @GetMapping("/loanStatus/{loanId}")
    public ResponseEntity<LoanDTO> getLoanStatus(@PathVariable long loanId) {
        try {
            LoanDTO loanDTO = loanServiceImpl.getLoanStatus(loanId);
            return new ResponseEntity<>(loanDTO, HttpStatus.OK);
        } catch (LoanNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam String accountNumber) {
        return accountServiceClient.getBalance(accountNumber);
    }
}
