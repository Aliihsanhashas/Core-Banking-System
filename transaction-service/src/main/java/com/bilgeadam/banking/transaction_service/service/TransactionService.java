package com.bilgeadam.banking.transaction_service.service;

import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllTransactions();

    TransactionDTO getTransactionById(Long transactionId);

    TransactionDTO processWithdrawal(String accountNumber, BigDecimal amount);

    TransactionDTO processDeposit(String accountNumber, BigDecimal amount);
}
