package com.bank.service;

import java.math.BigDecimal;

public interface TransactionService {
	void deposit(
            String accountNumber,
            BigDecimal amount
    );

    void withdraw(
            String accountNumber,
            BigDecimal amount
    );

    void transfer(
            String sourceAccount,
            String targetAccount,
            BigDecimal amount
    );

}
