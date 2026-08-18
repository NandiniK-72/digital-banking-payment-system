package com.bank.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.entity.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    public AdminController(CustomerRepository customerRepository,AccountRepository accountRepository,
            TransactionRepository transactionRepository) {
    	this.customerRepository =customerRepository;

        this.accountRepository =accountRepository;

        this.transactionRepository =transactionRepository;
    }
    
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts() {

        return accountRepository.findAll();
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {

        return transactionRepository.findAll();
    }
	
}
