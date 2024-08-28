package com.bilgeadam.banking.transaction_service.controller;

import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;
import com.bilgeadam.banking.transaction_service.service.TransactionService;
import com.bilgeadam.banking.transaction_service.service.TransactionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionServiceImpl transactionServiceImplt;

    public TransactionController(TransactionServiceImpl transactionServiceImplt) {
        this.transactionServiceImplt = transactionServiceImplt;
    }

   /* @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByAccountId(@PathVariable Long accountId) {
        List<TransactionDTO> transactions = transactionServiceImplt.getTransactionById(accountId);
        return ResponseEntity.ok(transactions);
    }
    */

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        TransactionDTO transaction = transactionServiceImplt.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionServiceImplt.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> processWithdrawal(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        TransactionDTO transaction = transactionServiceImplt.processWithdrawal(accountNumber, amount);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> processDeposit(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        TransactionDTO transaction = transactionServiceImplt.processDeposit(accountNumber, amount);
        return ResponseEntity.ok(transaction);
    }
}
