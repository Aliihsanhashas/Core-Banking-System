package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.Account;
import com.bilgeadam.banking.AccountServiceGrpc;
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
    public void getBalance(Account.GetBalanceRequest request, StreamObserver<Account.GetBalanceResponse> responseObserver) {
        //requestden accountNumber'i aldık
        String accountNumber = request.getAccountNumber();
        //DB de accountNumber'e ait balance değerini getirttik.
        //BigDecimal balance = accountService.getBalance(accountNumber);
        //yolladığımız kısım.
        Account.GetBalanceResponse response = Account.GetBalanceResponse.newBuilder()
                .setBalance("balance.toString()")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}