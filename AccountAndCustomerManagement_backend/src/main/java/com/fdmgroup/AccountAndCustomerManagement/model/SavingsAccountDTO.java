package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

public class SavingsAccountDTO {
	
	private long customerId;
	private double balance;
	private double interestRate;
	
	public SavingsAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavingsAccountDTO(long customerId, double balance, double interestRate) {
		super();
		this.customerId = customerId;
		this.balance = balance;
		this.interestRate = interestRate;
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
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "SavingsAccountDTO [customerId=" + customerId + ", balance=" + balance + ", interestRate=" + interestRate
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, customerId, interestRate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SavingsAccountDTO other = (SavingsAccountDTO) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& customerId == other.customerId
				&& Double.doubleToLongBits(interestRate) == Double.doubleToLongBits(other.interestRate);
	}
	
	
	
	

}
