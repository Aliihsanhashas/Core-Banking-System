package com.bilgeadam.banking.account_service.exception;

public class InvalidOperationException extends RuntimeException {

    // Varsayılan constructor
    public InvalidOperationException() {
        super();
    }

    // Mesaj parametresi ile constructor
    public InvalidOperationException(String message) {
        super(message);
    }

    // Mesaj ve neden parametreleri ile constructor
    public InvalidOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Neden parametresi ile constructor
    public InvalidOperationException(Throwable cause) {
        super(cause);
    }
}
