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
    private final AccountNumberGeneratorService accountNumberGeneratorService;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper
            , AccountNumberGeneratorService accountNumberGeneratorService) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.accountNumberGeneratorService = accountNumberGeneratorService;
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
        // 1. Hesap numarasını oluştur
        String accountNumber = accountNumberGeneratorService.generateAccountNumber();

        // 2. DTO'dan Domain nesnesini oluştur
        Account account = accountMapper.toDomain(accountDTO);

        // 3. Domain nesnesini Entity nesnesine dönüştür
        AccountEntity accountEntity = new AccountEntity(
                account.getId(),
                accountNumber,
                account.getAccountType(),
                account.getBalance(),
                account.getAccountHolderName(),
                account.getAccountHolderContact(),
                account.isClosed()
        );

        // 4. Entity nesnesini veritabanına kaydet
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);

        // 5. Kaydedilen Entity nesnesini Domain nesnesine dönüştür
        Account savedAccount = accountMapper.toDomain(savedAccountEntity);

        // 6. Domain nesnesini DTO'ya dönüştür ve geri döndür
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO updateAccount(String accountNumber, AccountDTO accountDTO) {
        // 1. Mevcut hesabı bul
        AccountEntity existingAccountEntity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account with number " + accountNumber + " not found"));
        // 2. Hesabın kapalı olup olmadığını kontrol et
        if (existingAccountEntity.isClosed()) {
            throw new IllegalStateException("Account is closed and cannot be updated.");
        }
        // 3. DTO'dan domain nesnesini oluştur
        Account updatedAccount = accountMapper.toDomain(accountDTO);
        // 4. Mevcut ID ve immutable alanlar korunarak yeni bir AccountEntity oluştur
        AccountEntity updatedAccountEntity = new AccountEntity(
                existingAccountEntity.getId(), // Koruduk
                existingAccountEntity.getAccountNumber(), // Koruduk
                existingAccountEntity.getAccountType(), // Koruduk
                updatedAccount.getBalance(), // Güncellenmiş bakiye
                updatedAccount.getAccountHolderName(), // Güncellenmiş hesap sahibi adı
                updatedAccount.getAccountHolderContact(), // Güncellenmiş hesap sahibi iletişimi
                existingAccountEntity.isClosed() // Koruduk
        );
        // 5. Güncellenmiş entity'yi kaydedin
        AccountEntity savedAccountEntity = accountRepository.save(updatedAccountEntity);
        Account savedAccount = accountMapper.toDomain(savedAccountEntity);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO closeAccount(String accountNumber) {
        // 1. Mevcut hesabı bul
        AccountEntity existingAccountEntity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account with number " + accountNumber + " not found"));

        // 2. Bakiyeyi kontrol et
        if (existingAccountEntity.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalStateException("Account cannot be closed because it has a non-zero balance.");
        }

        // 3. Mevcut hesabın kapalı olarak işaretlendiği yeni bir AccountEntity oluştur
        AccountEntity closedAccountEntity = new AccountEntity(
                existingAccountEntity.getId(), // ID korunur
                existingAccountEntity.getAccountNumber(), // Hesap numarası korunur
                existingAccountEntity.getAccountType(), // Hesap türü korunur
                existingAccountEntity.getBalance(), // Mevcut bakiye korunur
                existingAccountEntity.getAccountHolderName(), // Hesap sahibi adı korunur
                existingAccountEntity.getAccountHolderContact(), // Hesap sahibi iletişimi korunur
                true // Hesap kapalı olarak işaretlenir
        );

        // 4. Güncellenmiş entity'yi kaydedin
        AccountEntity savedAccountEntity = accountRepository.save(closedAccountEntity);

        // 5. Kaydedilen entity'yi domain nesnesine ve DTO'ya dönüştürün
        Account savedAccount = accountMapper.toDomain(savedAccountEntity);

        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public BigDecimal getBalance(String accountNumber) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account with number " + accountNumber + " not found"));
        Account account = accountMapper.toDomain(accountEntity);
        BigDecimal balance = account.getBalance();
        return balance;
    }


}