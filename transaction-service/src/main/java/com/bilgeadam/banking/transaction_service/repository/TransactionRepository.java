package com.bilgeadam.banking.transaction_service.repository;

import com.bilgeadam.banking.transaction_service.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// @Repository annotation to indicate that this is a Spring repository
@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
