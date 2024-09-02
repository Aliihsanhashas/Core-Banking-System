package com.bilgeadam.banking.transaction_service.service;

import com.bilgeadam.banking.transaction_service.domain.Transaction;
import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;
import com.bilgeadam.banking.transaction_service.entity.TransactionEntity;
import com.bilgeadam.banking.transaction_service.exception.TransactionNotFoundException;
import com.bilgeadam.banking.transaction_service.mapper.TransactionMapper;
import com.bilgeadam.banking.transaction_service.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper, TransactionNumberGeneratorService transactionNumberGeneratorService) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;

    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        // Veritabanından tüm TransactionEntity nesnelerini al
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();

        // TransactionEntity nesnelerini Transaction domain nesnelerine dönüştür
        List<Transaction> transactions = transactionEntities.stream()
                .map(transactionMapper::toDomain) // TransactionEntity'den Transaction domain'e dönüşüm
                .collect(Collectors.toList());

        // Transaction domain nesnelerini TransactionDTO'lara dönüştür
        List<TransactionDTO> transactionDTOs = transactions.stream()
                .map(transactionMapper::toDTO) // Transaction domain'den TransactionDTO'ya dönüşüm
                .collect(Collectors.toList());

        return transactionDTOs;
    }

    @Override
    public TransactionDTO getTransactionById(Long transactionId) {
        TransactionEntity transactionEntity = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with ID: " + transactionId));
        return transactionMapper.toDTO(transactionMapper.toDomain(transactionEntity));
    }

    @Override
    public TransactionDTO processWithdrawal(String accountNumber, BigDecimal amount) {
        // Withdrawal logic goes here
        // Similar to your AccountServiceImpl methods
        return null;
    }

    @Override
    public TransactionDTO processDeposit(String accountNumber, BigDecimal amount) {
        // Deposit logic goes here
        // Similar to your AccountServiceImpl methods
        return null;
    }
}
