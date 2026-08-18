package com.bank.serviceimpl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.service.TransactionService;

import jakarta.transaction.Transactional;


@Service
public class TransactionServiceImpl implements TransactionService{

	private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(
            AccountRepository accountRepository,
            TransactionRepository transactionRepository) {

        this.accountRepository =
                accountRepository;

        this.transactionRepository =
                transactionRepository;
    }
    
	@Override
	public void deposit(String accountNumber, BigDecimal amount) {
		Account account =
                accountRepository
                .findByAccountNumber(
                        accountNumber)
                .orElseThrow();

        account.setBalance(
                account.getBalance()
                .add(amount));

        accountRepository.save(account);
		
	}

	
	@Override
	public void withdraw(String accountNumber, BigDecimal amount) {
		Account account =
                accountRepository
                .findByAccountNumber(
                        accountNumber)
                .orElseThrow();

        if(account.getBalance()
                .compareTo(amount) < 0) {

            throw new RuntimeException(
                    "Insufficient Balance");
        }

        account.setBalance(
                account.getBalance()
                .subtract(amount));

        accountRepository.save(account);
		
	}

	
	
	@Override
    @Transactional

	public void transfer(String sourceAccountNumber, String targetAccountNumber, BigDecimal amount) {
		
		Account source =accountRepository
                .findByAccountNumber(sourceAccountNumber)
                .orElseThrow();

        Account target =accountRepository
                .findByAccountNumber(targetAccountNumber)
                .orElseThrow();
        
        if(source.getBalance().compareTo(amount) < 0) {

            throw new RuntimeException(
                    "Insufficient Balance");
        }
        
   //-------------------------------------------------------------------     
        source.setBalance(source.getBalance().subtract(amount));

        target.setBalance(target.getBalance().add(amount));

        accountRepository.save(source);

        accountRepository.save(target);

        Transaction transaction =
                new Transaction();

        transaction.setAmount(amount);

        transaction.setTransactionType(
                "TRANSFER");

        transaction.setSourceAccount(
                source);
        
        transaction.setTargetAccount(
                target);

        transactionRepository
                .save(transaction);
	}

}
