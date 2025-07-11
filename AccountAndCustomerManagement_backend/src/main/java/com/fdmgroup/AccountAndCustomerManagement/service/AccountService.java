package com.fdmgroup.AccountAndCustomerManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fdmgroup.AccountAndCustomerManagement.model.Account;
import com.fdmgroup.AccountAndCustomerManagement.model.AccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.CheckingAccount;
import com.fdmgroup.AccountAndCustomerManagement.model.CheckingsAccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.SavingsAccount;
import com.fdmgroup.AccountAndCustomerManagement.model.SavingsAccountDTO;
import com.fdmgroup.AccountAndCustomerManagement.repository.AccountRepository;
import com.fdmgroup.AccountAndCustomerManagement.repository.CustomerRepository;

import jakarta.validation.Valid;

@Service
public class AccountService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accRepository;
	
	public SavingsAccount createSavingsAccount(SavingsAccountDTO savingsDTO)
	{
		Customer customer = customerRepository.findById(savingsDTO.getCustomerId())
				.orElseThrow(() -> new CustomerNotFoundException(savingsDTO.getCustomerId()));
		SavingsAccount savings = new SavingsAccount();
		savings.setBalance(savingsDTO.getBalance());
		savings.setInterestRate(savingsDTO.getInterestRate());
		savings.setCustomer(customer);
		return accRepository.save(savings);
	}
	
	public CheckingAccount createCheckingsAccount(CheckingsAccountDTO checkingsDTO)
	{
		Customer customer = customerRepository.findById(checkingsDTO.getCustomerId())
				.orElseThrow(() -> new CustomerNotFoundException(checkingsDTO.getCustomerId()));
		CheckingAccount checking = new CheckingAccount();
		checking.setBalance(checkingsDTO.getBalance());
		checking.setNextCheckNumber(checkingsDTO.getNextCheckNumber());
		checking.setCustomer(customer);
		return accRepository.save(checking);
	}
	public List<Account> getAllAccountsByCustomerCity(String city)
	{
		List<Account> accounts = accRepository.findAccountIdsByCustomerCity(city);
		return accounts;
	}
	


	public List<Account> getAllAccounts() {
		return accRepository.findAll();
	}

	public Account findAccountById(long aCCOUNT_ID) {
		return accRepository.findById(aCCOUNT_ID)
				.orElseThrow(() -> new AccountNotFoundException(aCCOUNT_ID));
	}

	public void deleteByID(long aCCOUNT_ID) {
		
		if(accRepository.existsById(aCCOUNT_ID))
			accRepository.deleteById(aCCOUNT_ID);
		else
			throw new AccountNotFoundException(aCCOUNT_ID);
	}
	
	public Optional<Account> findAccountById(Long id) {
	    return accRepository.findById(id);
	}
	
	public Account updateAccount(long aCCOUNT_ID,@Valid AccountDTO accountDto )
	{
		Optional<Account> optAccount = accRepository.findById(aCCOUNT_ID);
		if(optAccount.isEmpty())
		{
			throw new AccountNotFoundException(aCCOUNT_ID);
		}
		
		Account account =optAccount.get();
		account.setBalance(accountDto.getBalance());
		if(account instanceof SavingsAccount && accountDto.getInterestRate()!=null)
		{
			 ((SavingsAccount) account).setInterestRate(accountDto.getInterestRate());
		}
		else if(account instanceof CheckingAccount && accountDto.getNextCheckNumber() != null) {
	        ((CheckingAccount) account).setNextCheckNumber(accountDto.getNextCheckNumber());
	    }

	    return accRepository.save(account);
	}
	
	
	


}
