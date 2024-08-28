package com.bilgeadam.banking.transaction_service.mapper;

import com.bilgeadam.banking.transaction_service.domain.Transaction;
import com.bilgeadam.banking.transaction_service.dto.TransactionDTO;
import com.bilgeadam.banking.transaction_service.entity.TransactionEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    // TransactionDTO'yu Transaction domain nesnesine dönüştür
    public Transaction toDomain(TransactionDTO transactionDTO) {
        if (transactionDTO == null) {
            return null;
        }
        return new Transaction.TransactionBuilder(
                transactionDTO.getId(),
                transactionDTO.getTransactionNumber(),
                transactionDTO.getTransactionType(),
                transactionDTO.getAmount()
        )
                .fromAccount(transactionDTO.getFromAccount())
                .toAccount(transactionDTO.getToAccount())
                .transactionDate(transactionDTO.getTransactionDate())
                .build();
    }

    // Transaction domain nesnesini TransactionDTO'ya dönüştür
    public TransactionDTO toDTO(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return new TransactionDTO(
                transaction.getId(),
                transaction.getTransactionNumber(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getFromAccount(),
                transaction.getToAccount(),
                transaction.getTransactionDate()
        );
    }

    // TransactionEntity'yi Transaction domain nesnesine dönüştür
    public Transaction toDomain(TransactionEntity transactionEntity) {
        if (transactionEntity == null) {
            return null;
        }
        return new Transaction.TransactionBuilder(
                transactionEntity.getId(),
                transactionEntity.getTransactionNumber(),
                transactionEntity.getTransactionType(),
                transactionEntity.getAmount()
        )
                .fromAccount(transactionEntity.getFromAccount())
                .toAccount(transactionEntity.getToAccount())
                .transactionDate(transactionEntity.getTransactionDate())
                .build();
    }

    // Transaction domain nesnesini TransactionEntity'ye dönüştür
    public TransactionEntity toEntity(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        return new TransactionEntity(
                transaction.getId(),
                transaction.getTransactionNumber(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getFromAccount(),
                transaction.getToAccount(),
                transaction.getTransactionDate()
        );
    }
}
