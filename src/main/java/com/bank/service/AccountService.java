package com.bank.service;

import com.bank.entity.Account;

public interface AccountService {

	Account createAccount(Long customerId,String accountType);

    Account getAccount(String accountNumber);
}
