package com.bilgeadam.banking.account_service.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;
@Service
@Transactional
public class AccountNumberGeneratorService {

    public String generateAccountNumber() {
        long timestamp = Instant.now().toEpochMilli();
        int randomNumber = new Random().nextInt(10000);
        return String.format("%d-%04d", timestamp, randomNumber);
    }

}
