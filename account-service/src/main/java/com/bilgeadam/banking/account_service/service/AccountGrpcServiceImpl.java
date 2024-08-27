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
    private final AccountServiceImpl accountService;

    public AccountGrpcServiceImpl(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void getBalance(GetBalanceRequest request, StreamObserver<GetBalanceResponse> responseObserver) {
        //requestden accountNumber'i aldık
        String accountNumber = request.getAccountNumber();
        //DB de accountNumber'e ait balance değerini getirttik.
        BigDecimal balance = accountService.getBalance(accountNumber);
        //yolladığımız kısım.
        GetBalanceResponse response = GetBalanceResponse.newBuilder()
                .setBalance(balance.toString())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}