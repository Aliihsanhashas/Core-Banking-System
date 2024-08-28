package com.bilgeadam.banking.loan_service.service;

import com.bilgeadam.banking.loan_service.dto.LoanDTO;

public interface LoanService {

    LoanDTO applyForLoan (LoanDTO loanDTO);

    LoanDTO getLoanStatus(Long loanId);

}
