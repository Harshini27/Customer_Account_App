package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class CheckingAccount extends Account{
	
	@NotNull
	private int nextCheckNumber;

	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(long aCCOUNT_ID, double balance, Customer customer) {
		super(aCCOUNT_ID, balance, customer);
		// TODO Auto-generated constructor stub
	}

	public CheckingAccount(int nextCheckNumber) {
		super();
		this.nextCheckNumber = nextCheckNumber;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nextCheckNumber);
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
		CheckingAccount other = (CheckingAccount) obj;
		return nextCheckNumber == other.nextCheckNumber;
	}
	
	
	
	
	
	

}
