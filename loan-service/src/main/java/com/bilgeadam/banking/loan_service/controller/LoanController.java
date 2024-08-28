package com.bilgeadam.banking.loan_service.controller;

import com.bilgeadam.banking.loan_service.dto.LoanDTO;
import com.bilgeadam.banking.loan_service.exception.LoanNotFoundException;
import com.bilgeadam.banking.loan_service.service.LoanService;
import com.bilgeadam.banking.loan_service.service.LoanServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/loan")
public class LoanController {
    private final LoanServiceImpl loanServiceImpl;

    public LoanController(LoanServiceImpl loanServiceImpl) {
        this.loanServiceImpl = loanServiceImpl;
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

    @PostMapping("/apply")
    public ResponseEntity<LoanDTO> applyForLoan(@RequestBody LoanDTO loanDTO) {
        try {
            LoanDTO createdLoanDTO = loanServiceImpl.applyForLoan(loanDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLoanDTO);
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
