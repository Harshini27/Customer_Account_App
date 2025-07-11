package com.fdmgroup.AccountAndCustomerManagement.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerTypeNotFoundException extends RuntimeException{
	
	public CustomerTypeNotFoundException(String customerType) {
		super("customer type" + customerType + "not found");
	}

}
