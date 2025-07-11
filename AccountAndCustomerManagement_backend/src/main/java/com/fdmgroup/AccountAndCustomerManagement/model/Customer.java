package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE" , discriminatorType = DiscriminatorType.STRING)
public abstract class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CUSTOMER_SEQ_GEN")
	@SequenceGenerator(name = "CUSTOMER_SEQ_GEN" , sequenceName = "CUSTOMER_SEQ" , initialValue = 1001 , allocationSize = 1)
	@Column(name="CUSTOMER_ID")
	private long customerId;

	@NotBlank(message  = "name cannot be blank")
	@Column(name="CUSTOMER_NAME", nullable = false)
    private String name;
	

	@Column(name="CUSTOMER_TYPE",  insertable = false,updatable = false)
	private String customerType;
	
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "FK_ADDRESS_ID", referencedColumnName = "addressId")
	@NotNull
    private Address address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Account> accounts;
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

    @Autowired
//	public Customer(long customerId, String name, Address address, List<Account> accounts) {
//		super();
//		this.customerId = customerId;
//		this.name = name;
//		this.address = address;
//		this.accounts = accounts;
//	}
    
    
    


	public Customer(long customerId, @NotBlank(message = "name cannot be blank") @NotNull String name,
			@NotBlank(message = "customerType is required") String customerType, @NotNull Address address,
			List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.customerType = customerType;
		this.address = address;
		this.accounts = accounts;
	}

    
	public String getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, address, customerId, customerType, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(address, other.address)
				&& customerId == other.customerId && Objects.equals(customerType, other.customerType)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", customerType=" + customerType + ", address="
				+ address + ", accounts=" + accounts + "]";
	}
   
	
	





  


    
	
	
    
    

}
