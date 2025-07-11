package com.fdmgroup.AccountAndCustomerManagement.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.AccountAndCustomerManagement.model.Account;
import com.fdmgroup.AccountAndCustomerManagement.model.AccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.CheckingAccount;
import com.fdmgroup.AccountAndCustomerManagement.model.CheckingsAccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.CustomerDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.SavingsAccount;
import com.fdmgroup.AccountAndCustomerManagement.model.SavingsAccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.service.AccountNotFoundException;
import com.fdmgroup.AccountAndCustomerManagement.service.AccountService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping("/savings")
	public ResponseEntity<SavingsAccount> createSavingsAccount(@RequestBody SavingsAccountDTO savings)
	{
		SavingsAccount saving = accountService.createSavingsAccount(savings);
		return ResponseEntity.ok(saving);
		
	}
	
	@PostMapping("/checking")
	public ResponseEntity<CheckingAccount> createCheckingsAccount(@RequestBody CheckingsAccountDTO checkings)
	{
		CheckingAccount checking = accountService.createCheckingsAccount(checkings);
		return ResponseEntity.ok(checking);
		
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List <Account>> getAllAccountsByCity(@PathVariable String city)
	{
		List<Account> accounts = accountService.getAllAccountsByCustomerCity(city);
		return ResponseEntity.ok(accounts);
		
	}
	
	@GetMapping
	public ResponseEntity<List <Account>> getAllAccounts()
	{
		List <Account> accounts = accountService.getAllAccounts();
		return ResponseEntity.ok(accounts);
	}
	
	
	@GetMapping("/id/{ACCOUNT_ID}")
	public ResponseEntity<Account> getAccountById(@PathVariable long ACCOUNT_ID)
	{
		Account account = accountService.findAccountById(ACCOUNT_ID);
		return ResponseEntity.ok(account);
		
	}
	
	@DeleteMapping("/{ACCOUNT_ID}")
	public ResponseEntity<Account> deleteAccount(@PathVariable long ACCOUNT_ID)
	{
		Account account = accountService.findAccountById(ACCOUNT_ID);
		accountService.deleteByID(ACCOUNT_ID);
		return ResponseEntity.ok(account); 
	}
	
	@PutMapping("/id/{ACCOUNT_ID}")
	public ResponseEntity<?> updateAccount(@PathVariable long ACCOUNT_ID,@Valid @RequestBody AccountDTO accountDto )
	{
		
	    try {
	        Account updated = accountService.updateAccount(ACCOUNT_ID, accountDto);
	        return ResponseEntity.ok(updated);
	    } catch (AccountNotFoundException ex) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	    }
	}
	
	
	
	
	
	
	

}
