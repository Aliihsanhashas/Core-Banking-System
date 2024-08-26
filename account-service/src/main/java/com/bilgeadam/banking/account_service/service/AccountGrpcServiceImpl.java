package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.AccountServiceGrpc;
import com.bilgeadam.banking.GetBalanceRequest;
import com.bilgeadam.banking.GetBalanceResponse;
import com.bilgeadam.banking.account_service.domain.Account;
import com.bilgeadam.banking.account_service.entity.AccountEntity;
import com.bilgeadam.banking.account_service.exception.AccountNotFoundException;
import com.bilgeadam.banking.account_service.mapper.AccountMapper;
import com.bilgeadam.banking.account_service.repository.AccountRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.math.BigDecimal;

@GrpcService
public class AccountGrpcServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountGrpcServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public void getBalance(GetBalanceRequest request, StreamObserver<GetBalanceResponse> responseObserver) {
        AccountEntity accountEntity = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Account with number " + request.getAccountNumber() + " not found"));
        Account account = accountMapper.toDomain(accountEntity);
        BigDecimal balance = account.getBalance();

        GetBalanceResponse response = GetBalanceResponse.newBuilder()
                .setBalance(balance.toString())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}