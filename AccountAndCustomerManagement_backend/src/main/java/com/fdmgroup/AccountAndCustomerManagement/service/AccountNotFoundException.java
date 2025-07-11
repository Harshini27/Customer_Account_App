package com.fdmgroup.AccountAndCustomerManagement.service;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException(long accID ) {
		super("account with " + accID + "not found");
	}

}
