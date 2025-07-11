package com.fdmgroup.AccountAndCustomerManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.AccountAndCustomerManagement.model.Address;
import com.fdmgroup.AccountAndCustomerManagement.model.Company;
import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.CustomerDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.GeoCoderDTO;
import com.fdmgroup.AccountAndCustomerManagement.model.Person;
import com.fdmgroup.AccountAndCustomerManagement.repository.CustomerRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;


@Service
@Transactional(readOnly=true)
public class CustomerServie {
	
	@PersistenceContext
	private EntityManager entityManager; 
	private CustomerRepository customerRepository;
	private GeoCoderService geocoderService;

	@Autowired
	public CustomerServie(CustomerRepository customerRepository,GeoCoderService geocoderService) 
	{
		super();
		this.customerRepository = customerRepository;
		this.geocoderService = geocoderService;
	}
	GeoCoderDTO geoAddress;
	@Transactional(readOnly = false)
	public Customer createCustomer(@Valid CustomerDTO customerDTO) 
	{
		geoAddress =geocoderService.getLocationByPostalCode(customerDTO.getPostalcode());
		if(geoAddress==null) 
		{
			throw new RuntimeException("city and province not found");
			
		}
		Customer customer;
		Address address=new Address();
		address.setStreetNumber(customerDTO.getStreetNumber());
		address.setCity(geoAddress.getCity());
		address.setPostalCode(customerDTO.getPostalcode());
		address.setProvince(geoAddress.getProvince());
		
		if((customerDTO.getCustomerType()).equalsIgnoreCase("Company"))
		{
			customer = new Company();

		}
		
		else if((customerDTO.getCustomerType()).equalsIgnoreCase("Person"))
		{
			customer = new Person();

		}
		
		else
		{
			throw new CustomerTypeNotFoundException(customerDTO.getCustomerType());
		}
		
		customer.setName(customerDTO.getName());
		customer.setAddress(address);
		Customer savedCustomer = customerRepository.save(customer);
		entityManager.flush();   
	    entityManager.refresh(savedCustomer);

	    return savedCustomer;
		

	}
	
	public Customer findCustomerById(long customerId)
	{
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
	}
	
	@Transactional(readOnly = false)
	public Customer updateCustomer(long customerId,CustomerDTO customerDto)
	{
	    Customer existingCustomer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new CustomerNotFoundException(customerId));

		geoAddress=geocoderService.getLocationByPostalCode(customerDto.getPostalcode());
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setCustomerType(customerDto.getCustomerType());
		
		Address exisitingAddress=existingCustomer.getAddress();
		
		exisitingAddress.setStreetNumber(customerDto.getStreetNumber());
		exisitingAddress.setCity(geoAddress.getCity());
		exisitingAddress.setPostalCode(customerDto.getPostalcode());
		exisitingAddress.setProvince(geoAddress.getProvince());
		
		return customerRepository.save(existingCustomer);
		
	}
	
	@Transactional(readOnly = false)
	public void deleteByID(long customerId)
	{
		if(customerRepository.existsById(customerId))
			customerRepository.deleteById(customerId);
		else
			throw new CustomerNotFoundException(customerId);
	}
	
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
		
	}

	public List<Customer> findCustomerByAccountBalance(double balance) {
		
		List<Customer> customers=customerRepository.findCustomerByAccountBalance(balance);
		return customers;
	}
}