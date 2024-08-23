package com.bilgeadam.banking.transaction_service.service;

import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;
import com.bilgeadam.banking.transaction_service.entity.TransactionEntity;
import com.bilgeadam.banking.transaction_service.exception.InvalidOperationException;
import com.bilgeadam.banking.transaction_service.exception.TransactionNotFoundException;
import com.bilgeadam.banking.transaction_service.mapper.TransactionMapper;
import com.bilgeadam.banking.transaction_service.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    // Hesap ID'sine göre işlemleri getirir
    public List<TransactionDTO> getTransactionsByAccountId(Long accountId) {
        List<TransactionEntity> transactions = transactionRepository.findByAccountId(accountId);
        return transactionMapper.toDTOList(transactions);
    }

    // İşlem ID'sine göre işlemi getirir
    public TransactionDTO getTransactionById(Long id) {
        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with ID: " + id));
        return transactionMapper.toDTO(transaction);
    }

    // Tüm işlemleri getirir
    public List<TransactionDTO> getAllTransactions() {
        List<TransactionEntity> transactions = transactionRepository.findAll();
        return transactionMapper.toDTOList(transactions);
    }

    // Para çekme işlemini gerçekleştirir
    public TransactionDTO processWithdrawal(Long accountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOperationException("Invalid withdrawal amount: " + amount);
        }

        // Hesap var mı kontrolü
        TransactionEntity transaction = transactionRepository.findByAccountId(accountId)
                .orElseThrow(() -> new TransactionNotFoundException("Account not found with ID: " + accountId));

        // Yeterli bakiye kontrolü
        if (transaction.getAmount().compareTo(amount) < 0) {
            throw new InvalidOperationException("Insufficient funds for account ID: " + accountId);
        }

        // Çekme işlemini güncelle
        transaction.setAmount(transaction.getAmount().subtract(amount));
        transactionRepository.save(transaction);

        return transactionMapper.toDTO(transaction);
    }

    // Para yatırma işlemini gerçekleştirir
    public TransactionDTO processDeposit(Long accountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOperationException("Invalid deposit amount: " + amount);
        }

        // Hesap var mı kontrolü
        TransactionEntity transaction = transactionRepository.findByAccountId(accountId)
                .orElseThrow(() -> new TransactionNotFoundException("Account not found with ID: " + accountId));

        // Yatırma işlemini güncelle
        transaction.setAmount(transaction.getAmount().add(amount));
        transactionRepository.save(transaction);

        return transactionMapper.toDTO(transaction);
    }
}
