package com.fdmgroup.AccountAndCustomerManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.AccountAndCustomerManagement.model.Account;
import com.fdmgroup.AccountAndCustomerManagement.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query("SELECT cust from Customer cust "+
			"join cust.accounts acc " +
			"where acc.balance = :balance")
	List<Customer> findCustomerByAccountBalance(@Param("balance") double balance);
	
	
	

}
