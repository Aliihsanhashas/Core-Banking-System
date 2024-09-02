package com.bilgeadam.banking.loan_service.service;


import com.bilgeadam.banking.loan_service.domain.Loan;
import com.bilgeadam.banking.loan_service.dto.LoanDTO;
import com.bilgeadam.banking.loan_service.entity.LoanEntity;
import com.bilgeadam.banking.loan_service.mapper.LoanMapper;
import com.bilgeadam.banking.loan_service.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;


    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
        this.loanMapper = new LoanMapper();
    }


    @Override
    public LoanDTO getLoanStatus(Long loanId) {
        LoanEntity loanEntity = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found with id: " + loanId));

        Loan loan = loanMapper.toDomain(loanEntity);
        LoanDTO loanDTO = loanMapper.toDTO(loan);
        return loanDTO;
    }

    @Override
    public LoanDTO makeRepayment(Long loanId, BigDecimal repaymentAmount) {
        Optional<LoanEntity> optionalLoanEntity = loanRepository.findById(loanId);

        if (!optionalLoanEntity.isPresent()) {
            throw new RuntimeException("Loan not found");
        }

        LoanEntity loanEntity = optionalLoanEntity.get();

        Loan loan = loanMapper.toDomain(loanEntity);

        BigDecimal newRemainingBalance = loan.getRemainingBalance().subtract(repaymentAmount);
        Loan updatedLoan = new Loan.LoanBuilder(
                loan.getAccountNumber(),
                loan.getLoanAmount(),
                loan.getCreationDate(),
                loan.getDueDate(),
                loan.getInterestRate()
        )
                .status(loan.getStatus())
                .remainingBalance(newRemainingBalance)
                .build();

        // Güncellenmiş kredi nesnesini tekrar entity'ye dönüştür
        LoanEntity updatedLoanEntity = loanMapper.toEntity(updatedLoan);

        // Güncellenmiş kredi nesnesini veri tabanına kaydet
        loanRepository.save(updatedLoanEntity);

        // DTO olarak geri döndür
        return loanMapper.toDTO(updatedLoan);
    }
}
