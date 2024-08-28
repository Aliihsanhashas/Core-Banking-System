package com.bilgeadam.banking.transaction_service.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

@Service
@Transactional
public class TransactionNumberGeneratorService {

    public String generateTransactionNumber() {
        long timestamp = Instant.now().toEpochMilli();
        int randomNumber = new Random().nextInt(10000);
        return String.format("TXN-%d-%04d", timestamp, randomNumber);
    }
}