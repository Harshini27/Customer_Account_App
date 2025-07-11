package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

public class CheckingsAccountDTO {
	
	private long customerId;
	private double balance;
	private int nextCheckNumber;
	
	public CheckingsAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

    public CheckingsAccountDTO(long customerId, double balance, int nextCheckNumber) {
		super();
		this.customerId = customerId;
		this.balance = balance;
		this.nextCheckNumber = nextCheckNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingsAccountDTO [customerId=" + customerId + ", balance=" + balance + ", nextCheckNumber="
				+ nextCheckNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, customerId, nextCheckNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckingsAccountDTO other = (CheckingsAccountDTO) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& customerId == other.customerId && nextCheckNumber == other.nextCheckNumber;
	}
    
    
	
	
	

}
