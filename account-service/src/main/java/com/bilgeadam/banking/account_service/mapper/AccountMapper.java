package com.bilgeadam.banking.account_service.mapper;

import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.dto.AccountDTO;
import com.bilgeadam.banking.account_service.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    // AccountDTO'yu Account domain nesnesine dönüştür
    public Account toDomain(AccountDTO accountDTO) {
        if (accountDTO == null) {
            return null;
        }
        return new Account.AccountBuilder(
                accountDTO.getAccountNumber(),
                accountDTO.getAccountType(),
                accountDTO.getAccountHolderName(),
                accountDTO.getAccountHolderContact()
        )
                .balance(accountDTO.getBalance())
                .isClosed(accountDTO.isClosed())
                .build();
    }

    // Account domain nesnesini AccountDTO'ya dönüştür
    public AccountDTO toDTO(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDTO(
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getAccountHolderName(),
                account.getAccountHolderContact(),
                account.isClosed()
        );
    }

    // AccountEntity'yi Account domain nesnesine dönüştür
    public Account toDomain(AccountEntity accountEntity) {
        if (accountEntity == null) {
            return null;
        }
        return new Account.AccountBuilder(
                accountEntity.getAccountNumber(),
                accountEntity.getAccountType(),
                accountEntity.getAccountHolderName(),
                accountEntity.getAccountHolderContact()
        )
                .balance(accountEntity.getBalance())
                .isClosed(accountEntity.isClosed())
                .build();
    }

    // Account domain nesnesini AccountEntity'ye dönüştür
    public AccountEntity toEntity(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountEntity(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getAccountHolderName(),
                account.getAccountHolderContact(),
                account.isClosed()
        );
    }
}