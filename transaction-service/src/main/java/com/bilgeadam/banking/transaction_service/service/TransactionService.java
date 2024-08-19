package com.bilgeadam.banking.transaction_service.service;

import com.bilgeadam.banking.transaction_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Transaction işlemlerine dair metodlar burada tanımlanacak
}
