package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Account;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }
    

    @PostMapping
    public Account createAccount(@RequestParam Long customerId,@RequestParam String accountType) {
          return service.createAccount(customerId,accountType);
    }
    
    
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {

        return service.getAccount(accountNumber);
    }
}
