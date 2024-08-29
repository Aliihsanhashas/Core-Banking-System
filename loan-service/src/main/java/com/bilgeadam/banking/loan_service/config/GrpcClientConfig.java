package com.bilgeadam.banking.loan_service.config;

import com.bilgeadam.banking.AccountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel managedChannel() {
        // Replace with your server's address and port
        return ManagedChannelBuilder.forAddress("192.168.1.31", 6565)
                .usePlaintext() // Use plaintext communication; use SSL/TLS in production
                .build();
    }

    @Bean
    public AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub(ManagedChannel channel) {
        return AccountServiceGrpc.newBlockingStub(channel);
    }
}

