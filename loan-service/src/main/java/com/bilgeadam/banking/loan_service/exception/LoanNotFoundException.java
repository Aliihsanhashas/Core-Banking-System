package com.bilgeadam.banking.loan_service.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message) {
        super(message);
    }

    public LoanNotFoundException(Long loanId) {
        super("Loan not found with id: " + loanId);
    }

}
