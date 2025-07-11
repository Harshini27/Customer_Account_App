package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;

import org.springframework.beans.factory.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
    @NotNull
	private String streetNumber;
    @NotNull
	private String postalCode;
    @NotNull
	private String city;
    @NotNull
	private String province;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public Address(long addressId, String streetNumber, String postalCode, String city, String province) {
		super();
		this.addressId = addressId;
		this.streetNumber = streetNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, city, postalCode, province, streetNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(city, other.city)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(province, other.province)
				&& Objects.equals(streetNumber, other.streetNumber);
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNumber=" + streetNumber + ", postalCode=" + postalCode
				+ ", city=" + city + ", province=" + province + "]";
	}
	

}
