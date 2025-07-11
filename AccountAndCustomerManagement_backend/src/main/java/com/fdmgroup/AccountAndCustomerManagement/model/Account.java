package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ACCOUNT_ID;
	
	
	@NotNull
	private double balance;
	
	@ManyToOne
	@JoinColumn(name = "FK_CUST_ID",referencedColumnName = "CUSTOMER_ID")
	@JsonBackReference
	private Customer customer;
	
	public Account() {
		super();
		this.ACCOUNT_ID = ACCOUNT_ID;

		// TODO Auto-generated constructor stub
	}

	@Autowired
	public Account(long aCCOUNT_ID, double balance, Customer customer) {
		super();
		ACCOUNT_ID = aCCOUNT_ID;
		this.balance = balance;
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}

	@Override
	public String toString() {
		return "Account [ACCOUNT_ID=" + ACCOUNT_ID + ", balance=" + balance + ", customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ACCOUNT_ID, balance, customer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return ACCOUNT_ID == other.ACCOUNT_ID
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(customer, other.customer);
	}
	
	
	
	
	
	
	
	

}
