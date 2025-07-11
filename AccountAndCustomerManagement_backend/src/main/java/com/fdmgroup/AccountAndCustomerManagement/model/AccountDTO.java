package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

public class AccountDTO {
	
    private double balance;
    private Integer interestRate;     
    private Integer nextCheckNumber;
    
	public AccountDTO(double balance, Integer interestRate, Integer nextCheckNumber) {
		super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.nextCheckNumber = nextCheckNumber;
	}  
    
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Integer getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getNextCheckNumber() {
		return nextCheckNumber;
	}
	public void setNextCheckNumber(Integer nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "AccountDTO [balance=" + balance + ", interestRate=" + interestRate + ", nextCheckNumber="
				+ nextCheckNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, interestRate, nextCheckNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDTO other = (AccountDTO) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(interestRate, other.interestRate)
				&& Objects.equals(nextCheckNumber, other.nextCheckNumber);
	}
	
	

    
    
    
    

}
