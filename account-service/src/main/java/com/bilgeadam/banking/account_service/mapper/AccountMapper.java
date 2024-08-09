package com.bilgeadam.banking.account_service.mapper;

import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.dto.AccountDTO;
import com.bilgeadam.banking.account_service.entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    // AccountDTO'yu AccountDomain nesnesine dönüştür
    public Account toDomain(AccountDTO accountDTO) {
        return new Account.AccountBuilder(
                accountDTO.getId(),
                accountDTO.getAccountNumber(),
                accountDTO.getAccountType(),
                accountDTO.getAccountHolderName(),
                accountDTO.getAccountHolderContact()
        )
                .balance(accountDTO.getBalance())
                .isClosed(accountDTO.isClosed())
                .build();
    }

    // AccountDomain'i AccountDTO nesnesine dönüştür
    public AccountDTO toDTO(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getAccountHolderName(),
                account.getAccountHolderContact(),
                account.isClosed()
        );
    }

    // AccountEntity'yi AccountDomain nesnesine dönüştür
    public Account toDomain(AccountEntity accountEntity) {
        return new Account.AccountBuilder(
                accountEntity.getId(),
                accountEntity.getAccountNumber(),
                accountEntity.getAccountType(),
                accountEntity.getAccountHolderName(),
                accountEntity.getAccountHolderContact()
        )
                .balance(accountEntity.getBalance())
                .isClosed(accountEntity.isClosed())
                .build();
    }

    // AccountDomain'i AccountEntity nesnesine dönüştür
    public AccountEntity toEntity(Account account) {
        return new AccountEntity(
                account.getAccountNumber(),
                account.getAccountType(),
                account.getBalance(),
                account.getAccountHolderName(),
                account.getAccountHolderContact(),
                account.isClosed()
        );
    }
}
