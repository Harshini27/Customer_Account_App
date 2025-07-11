package com.fdmgroup.AccountAndCustomerManagement.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.GeoCoderDTO;

@Service
public interface IGeoCoderClient {

	GeoCoderDTO getLocationByPostalCode(String postalcode);
	

}
