package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.account_service.exception.AccountNotFoundException;
import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.dto.AccountDTO;
import com.bilgeadam.banking.account_service.entity.AccountEntity;
import com.bilgeadam.banking.account_service.mapper.AccountMapper;
import com.bilgeadam.banking.account_service.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        //Hepsini db den çekiyor
        List<AccountEntity> accountEntities = accountRepository.findAll();

        //AccountEntity nesnelerini Domaine dönüştürüyor
        List<Account> accounts = accountEntities.stream()
                .map(accountMapper::toDomain)
                .collect(Collectors.toList());

        //Domain nesnlerini DTO'lara dönüştürüyor.
        List<AccountDTO> accountDTOS = accounts.stream()
                .map(accountMapper::toDTO)
                .collect(Collectors.toList());
        return accountDTOS;
    }

    @Override
    public AccountDTO getAccountByNumber(String accountNumber) {
        Optional<AccountEntity> accountEntityOptional = accountRepository.findByAccountNumber(accountNumber);

        if (accountEntityOptional.isPresent()) {
            AccountEntity accountEntity = accountEntityOptional.get();
            Account account = accountMapper.toDomain(accountEntity);
            return accountMapper.toDTO(account);
        } else {
            throw new AccountNotFoundException("Account with number " + accountNumber + " not found");
        }
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {

        if (accountDTO.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

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