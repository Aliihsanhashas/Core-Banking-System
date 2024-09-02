package com.bilgeadam.banking.loan_service.service;

import com.bilgeadam.banking.loan_service.dto.LoanDTO;

import java.math.BigDecimal;

public interface LoanService {

    LoanDTO getLoanStatus(Long loanId);

    LoanDTO makeRepayment(Long loanId, BigDecimal repaymentAmount);

}
