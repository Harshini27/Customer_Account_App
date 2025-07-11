package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.constraints.NotBlank;

public class CustomerDTO {
	
	
	@NotBlank(message = "Name is required")

	private String name; 
	
	@NotBlank(message = "customerType is required")
	private String customerType;
	
	@NotBlank(message = "Street number is required")
	private String streetNumber;
	
	@NotBlank(message = "Postal code is required")
	private String postalcode;
	
	@Autowired
//	public CustomerDTO(String name, String streetNumber, String postalcode) {
//		super();
//		this.name = name;
//		this.streetNumber = streetNumber;
//		this.postalcode = postalcode;
//	}
	public CustomerDTO(@NotBlank(message = "Name is required") String name,
			String customerType,
			@NotBlank(message = "Street number is required") String streetNumber,
			@NotBlank(message = "Postal code is required") String postalcode) {
		super();
		this.name = name;
		this.customerType = customerType;
		this.streetNumber = streetNumber;
		this.postalcode = postalcode;
	}


	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
		
	public String getCustomerType() {
		return customerType;
	}


	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", customerType=" + customerType + ", streetNumber=" + streetNumber
				+ ", postalcode=" + postalcode + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(customerType, name, postalcode, streetNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(customerType, other.customerType) && Objects.equals(name, other.name)
				&& Objects.equals(postalcode, other.postalcode) && Objects.equals(streetNumber, other.streetNumber);
	}	
	
}
