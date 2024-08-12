package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.domain.AccountType;
import com.bilgeadam.banking.account_service.dto.AccountDTO;
import com.bilgeadam.banking.account_service.entity.AccountEntity;
import com.bilgeadam.banking.account_service.mapper.AccountMapper;
import com.bilgeadam.banking.account_service.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        // DTO'yu Domain nesnesine dönüştür
        Account account = accountMapper.toDomain(accountDTO);

        // Domain nesnesini Entity nesnesine dönüştür
        AccountEntity accountEntity = accountMapper.toEntity(account);

        // Entity nesnesini veritabanına kaydet
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);

        // Kaydedilen Entity nesnesini Domain nesnesine dönüştür
        Account savedAccount = accountMapper.toDomain(savedAccountEntity);

        // Domain nesnesini DTO'ya dönüştür ve geri döndür
        return accountMapper.toDTO(savedAccount);
    }
}
