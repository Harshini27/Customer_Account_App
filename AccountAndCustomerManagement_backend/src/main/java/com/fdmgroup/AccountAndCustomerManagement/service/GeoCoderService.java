package com.fdmgroup.AccountAndCustomerManagement.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.GeoCoderDTO;

@Service
public class GeoCoderService {
	
	private IGeoCoderClient geocoderClient;

	public GeoCoderService(IGeoCoderClient geocoderClient) {
		super();
		this.geocoderClient = geocoderClient;
	}
     	
	public GeoCoderDTO getLocationByPostalCode(String postalcode)
	{
		return geocoderClient.getLocationByPostalCode(postalcode);
	}
	

}
