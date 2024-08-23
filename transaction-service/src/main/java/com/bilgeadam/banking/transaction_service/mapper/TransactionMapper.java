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

    // TransactionEntity'yi TransactionDTO'ya dönüştür
    public TransactionDTO toDTO(TransactionEntity transactionEntity) {
        if (transactionEntity == null) {
            return null;
        }
        return new TransactionDTO(
                transactionEntity.getId(),
                transactionEntity.getTransactionNumber(),
                transactionEntity.getTransactionType(),
                transactionEntity.getAmount(),
                transactionEntity.getFromAccount(),
                transactionEntity.getToAccount(),
                transactionEntity.getTransactionDate()
        );
    }

    // List<TransactionEntity> listesini List<TransactionDTO> listesine dönüştür
    public List<TransactionDTO> toDTOList(List<TransactionEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDTO) // Bu, TransactionEntity'den TransactionDTO'ya dönüşümü sağlar
                .collect(Collectors.toList());
    }
}
