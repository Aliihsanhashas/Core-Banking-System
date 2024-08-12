package com.bilgeadam.banking.transaction_service.domain;

public enum TransactionType {
    DEPOSIT,       // Para yatırma işlemi
    WITHDRAWAL,    // Para çekme işlemi
    TRANSFER,      // Para transferi işlemi
    PAYMENT;       // Ödeme işlemi

    // Enum sabitleri üzerinde işlemler yapmak istiyorsanız, burada ek metodlar da tanımlayabilirsiniz.
}
