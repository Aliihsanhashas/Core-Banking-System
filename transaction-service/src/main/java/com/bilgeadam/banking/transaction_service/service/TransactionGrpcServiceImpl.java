package com.bilgeadam.banking.transaction_service.service;

import com.bilgeadam.banking.TransactionServiceGrpc;
import com.bilgeadam.banking.WithdrawRequest;
import com.bilgeadam.banking.WithdrawResponse;
import com.bilgeadam.banking.DepositRequest;
import com.bilgeadam.banking.DepositResponse;
import com.bilgeadam.banking.transaction_service.repository.TransactionRepository;
import com.bilgeadam.banking.transaction_service.entity.TransactionEntity;
import com.bilgeadam.banking.transaction_service.exception.TransactionNotFoundException;
import com.bilgeadam.banking.transaction_service.mapper.TransactionMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@GrpcService
public class TransactionGrpcServiceImpl extends TransactionServiceGrpc.TransactionServiceImplBase {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionGrpcServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public void withdraw(WithdrawRequest request, StreamObserver<WithdrawResponse> responseObserver) {
        // Implement withdraw logic using the repository and mapper
    }

    @Override
    public void deposit(DepositRequest request, StreamObserver<DepositResponse> responseObserver) {
        // Implement deposit logic using the repository and mapper
    }
}
