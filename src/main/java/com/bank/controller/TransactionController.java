package com.bank.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	private final TransactionService service;

    public TransactionController(
            TransactionService service) {

        this.service = service;
    }
    
    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber,@RequestParam BigDecimal amount) {

        service.deposit(accountNumber,amount);

        return "Deposit Successful";
    }
    
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber,@RequestParam BigDecimal amount) {

        service.withdraw(accountNumber,amount);

        return "Withdrawal Successful";
    }
    
    @PostMapping("/transfer")
    public String transfer(@RequestParam String sourceAccount,@RequestParam String targetAccount,@RequestParam
            BigDecimal amount) {

        service.transfer(sourceAccount,targetAccount,amount);

        return "Transfer Successful";
    }


}
