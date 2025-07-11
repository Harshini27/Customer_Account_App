package com.fdmgroup.AccountAndCustomerManagement.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.fdmgroup.AccountAndCustomerManagement.model.Customer;
import com.fdmgroup.AccountAndCustomerManagement.model.CustomerDTO;
import com.fdmgroup.AccountAndCustomerManagement.service.CustomerServie;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

	CustomerServie customerService;

	@Autowired
	public CustomerController(CustomerServie customerService) {
		super();
		this.customerService = customerService;
	}
	
//	@PostMapping
//	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer)
//	{
//		Customer createdCustomer = customerService.createCustomer(customer);
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{customerId}")
//				.buildAndExpand(createdCustomer.getCustomerId())
//				.toUri();
//		return ResponseEntity.created(location).body(createdCustomer);
//		
//	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDTO customerDTO)
	{
		Customer createdCustomer = customerService.createCustomer(customerDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{customerId}")
				.buildAndExpand(createdCustomer.getCustomerId())
				.toUri();
		return ResponseEntity.created(location).body(createdCustomer);
		
	}
	
	
	
	@GetMapping("/id/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable long customerId)
	{
		Customer customer = customerService.findCustomerById(customerId);
		return ResponseEntity.ok(customer);
		
	}
	
	@GetMapping
	public ResponseEntity<List <Customer>> getAllCustomers()
	{
		List <Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteContact(@PathVariable long customerId)
	{
		Customer customer = customerService.findCustomerById(customerId);
		customerService.deleteByID(customerId);
		return ResponseEntity.ok(customer); 
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long customerId,@Valid @RequestBody CustomerDTO customerDto )
	{
//		customer.setCustomerId(customerId);
		Customer updateCustomer = customerService.updateCustomer(customerId,customerDto);
		return ResponseEntity.ok(updateCustomer);
		
	}
	@GetMapping("/balance/{balance}")
	public ResponseEntity<List <Customer>> getCustomerByBalance(@PathVariable double balance)
	{
		List<Customer> customers = customerService.findCustomerByAccountBalance(balance);
		return ResponseEntity.ok(customers);
		
	}
	
}
