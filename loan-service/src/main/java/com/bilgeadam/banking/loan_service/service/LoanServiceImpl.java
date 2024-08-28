package com.bilgeadam.banking.loan_service.service;


import com.bilgeadam.banking.loan_service.domain.Loan;
import com.bilgeadam.banking.loan_service.dto.LoanDTO;
import com.bilgeadam.banking.loan_service.entity.LoanEntity;
import com.bilgeadam.banking.loan_service.mapper.LoanMapper;
import com.bilgeadam.banking.loan_service.repository.LoanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
    public LoanDTO applyForLoan(LoanDTO loanDTO) {
        // LoanDTO'yu Loan domain nesnesine dönüştür
        Loan loan = loanMapper.toDomain(loanDTO);
        // Loan nesnesini Entity nesnesine dönüştür
        LoanEntity loanEntity = loanMapper.toEntity(loan);
        // Entity nesnesini veritabanına kaydet
        LoanEntity savedLoanEntity = loanRepository.save(loanEntity);
        // Kaydedilen Entity nesnesini Domain nesnesine dönüştür
        Loan savedLoan = loanMapper.toDomain(savedLoanEntity);
        // Domain nesnesini DTO'ya dönüştür ve geri döndür
        return loanMapper.toDTO(savedLoan);
    }

    @Override
    public LoanDTO getLoanStatus(Long loanId) {
        LoanEntity loanEntity = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found with id: " + loanId));

        Loan loan = loanMapper.toDomain(loanEntity);
        LoanDTO loanDTO = loanMapper.toDTO(loan);
        return loanDTO;
    }
}
