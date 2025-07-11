package com.fdmgroup.AccountAndCustomerManagement.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(long id) {
		super("customer Id" +id +"not found");
		// TODO Auto-generated constructor stub
	}

	
}
