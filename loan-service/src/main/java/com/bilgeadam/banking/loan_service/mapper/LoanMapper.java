package com.bilgeadam.banking.loan_service.mapper;

import com.bilgeadam.banking.loan_service.domain.Loan;
import com.bilgeadam.banking.loan_service.domain.LoanStatus;
import com.bilgeadam.banking.loan_service.dto.LoanDTO;
import com.bilgeadam.banking.loan_service.entity.LoanEntity;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    // LoanDTO'yu Loan domain nesnesine dönüştür
    public Loan toDomain(LoanDTO loanDTO) {
        if (loanDTO == null) {
            return null;
        }
        return new Loan.LoanBuilder(
                loanDTO.getAccountNumber(),
                loanDTO.getLoanAmount(),
                loanDTO.getCreationDate(),
                loanDTO.getDueDate(),
                loanDTO.getInterestRate()
        )
                .status(loanDTO.getStatus())
                .remainingBalance(loanDTO.getRemainingBalance())
                .build();
    }

    // Loan domain nesnesini LoanDTO'ya dönüştür
    public LoanDTO toDTO(Loan loan) {
        if (loan == null) {
            return null;
        }
        return new LoanDTO(
                loan.getAccountNumber(),
                loan.getLoanAmount(),
                loan.getCreationDate(),
                loan.getDueDate(),
                loan.getInterestRate(),
                loan.getStatus(),
                loan.getRemainingBalance()
        );
    }

    // LoanEntity'yi Loan domain nesnesine dönüştür
    public Loan toDomain(LoanEntity loanEntity) {
        if (loanEntity == null) {
            return null;
        }
        return new Loan.LoanBuilder(
                loanEntity.getAccountNumber(),
                loanEntity.getLoanAmount(),
                loanEntity.getCreationDate(),
                loanEntity.getDueDate(),
                loanEntity.getInterestRate()
        )
                .id(loanEntity.getId())
                .status(loanEntity.getStatus()) // Enums dönüşümü
                .remainingBalance(loanEntity.getRemainingBalance())
                .build();
    }

    // Loan domain nesnesini LoanEntity'ye dönüştür
    public LoanEntity toEntity(Loan loan) {
        if (loan == null) {
            return null;
        }
        return new LoanEntity(
                loan.getId(),
                loan.getAccountNumber(),
                loan.getLoanAmount(),
                loan.getCreationDate(),
                loan.getDueDate(),
                loan.getStatus(),
                loan.getInterestRate(),
                loan.getRemainingBalance()
        );
    }
}
