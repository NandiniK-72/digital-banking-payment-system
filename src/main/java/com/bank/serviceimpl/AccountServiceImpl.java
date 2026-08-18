package com.bank.serviceimpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private final AccountRepository accountRepository;
	private final CustomerRepository customerRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository,CustomerRepository customerRepository) {
          this.accountRepository = accountRepository;
          this.customerRepository =customerRepository;
    }
	
	
	@Override
	public Account createAccount(Long customerId, String accountType) {
		Customer customer =
                customerRepository
                .findById(customerId)
                .orElseThrow();

        Account account = new Account();

        account.setCustomer(customer);

        account.setAccountType(
                accountType);

        account.setStatus("ACTIVE");

        account.setBalance(
                BigDecimal.ZERO);

        account.setAccountNumber(
                generateAccountNumber());

        return accountRepository.save(
                account);
	}

	private String generateAccountNumber() {

        return String.valueOf(System.currentTimeMillis());
    }



	@Override
	public Account getAccount(String accountNumber) {
		return accountRepository
                .findByAccountNumber(
                        accountNumber)
                .orElseThrow();
	}

}
