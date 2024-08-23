package com.bilgeadam.banking.transaction_service.exception;

public class InvalidOperationException extends RuntimeException {

    // Default constructor
    public InvalidOperationException() {
        super();
    }

    // Constructor with message parameter
    public InvalidOperationException(String message) {
        super(message);
    }

    // Constructor with message and cause parameters
    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with cause parameter
    public InvalidOperationException(Throwable cause) {
        super(cause);
    }
}
