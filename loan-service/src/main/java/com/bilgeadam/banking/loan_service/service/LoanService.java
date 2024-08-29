package com.bilgeadam.banking.loan_service.service;

import com.bilgeadam.banking.loan_service.dto.LoanDTO;

public interface LoanService {

    LoanDTO getLoanStatus(Long loanId);

}
