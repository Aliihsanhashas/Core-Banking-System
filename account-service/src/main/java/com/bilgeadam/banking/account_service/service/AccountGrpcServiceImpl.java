package com.bilgeadam.banking.account_service.service;

import com.bilgeadam.banking.Account;
import com.bilgeadam.banking.AccountServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AccountGrpcServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {

    @Override
    public void getBalance(Account.GetBalanceRequest request, StreamObserver<Account.GetBalanceResponse> responseObserver) {
        System.out.println("request to grpc");
        Account.GetBalanceResponse response = Account.GetBalanceResponse.newBuilder()
                .setBalance("1001")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}