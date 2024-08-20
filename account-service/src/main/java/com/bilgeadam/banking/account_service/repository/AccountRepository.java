package com.bilgeadam.banking.account_service.repository;

import com.bilgeadam.banking.account_service.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

// ilk iş hemen anatasyonumuzu yapıştırdık.
//@Repository, Spring Boot uygulamalarında veri erişim katmanı (Data Access Layer) için kullanılan bir annotasyondur.
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    // Hesap numarasına göre AccountEntity'yi bulur
    Optional<AccountEntity> findByAccountNumber(String accountNumber);


    // Hesap numarasına göre bakiye (balance) sorgulamak için metod
    BigDecimal findBalanceByAccountNumber(String accountNumber);



}
