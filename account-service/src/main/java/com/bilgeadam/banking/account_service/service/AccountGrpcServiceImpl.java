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

}