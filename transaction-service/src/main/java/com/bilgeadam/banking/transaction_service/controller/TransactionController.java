package com.bilgeadam.banking.transaction_service.controller;

import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;
import com.bilgeadam.banking.transaction_service.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByAccountId(@PathVariable Long accountId) {
        List<TransactionDTO> transactions = transactionService.getTransactionsByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id) {
        TransactionDTO transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionDTO> processWithdrawal(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        TransactionDTO transaction = transactionService.processWithdrawal(accountId, amount);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/deposit")
    public ResponseEntity<TransactionDTO> processDeposit(@RequestParam Long accountId, @RequestParam BigDecimal amount) {
        TransactionDTO transaction = transactionService.processDeposit(accountId, amount);
        return ResponseEntity.ok(transaction);
    }
}
