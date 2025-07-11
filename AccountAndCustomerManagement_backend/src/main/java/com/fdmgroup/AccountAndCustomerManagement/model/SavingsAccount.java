package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class SavingsAccount extends Account {
	
	@NotNull
	private double interestRate;
	
	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(long aCCOUNT_ID, double balance, Customer customer) {
		super(aCCOUNT_ID, balance, customer);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(double interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(interestRate);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingsAccount other = (SavingsAccount) obj;
		return Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate);
	}
	
	
	
	

}
