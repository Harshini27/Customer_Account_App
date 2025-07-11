package com.fdmgroup.AccountAndCustomerManagement.model;

import java.util.Objects;


public class GeoCoderDTO {
	private String city;
	private String province;
	
	
	public GeoCoderDTO(String city, String province) {
		super();
		this.city = city;
		this.province = province;
	}
	
	


	public GeoCoderDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return "GeoCoderDTO [city=" + city + ", province=" + province + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(city, province);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoCoderDTO other = (GeoCoderDTO) obj;
		return Objects.equals(city, other.city) && Objects.equals(province, other.province);
	}
	
	
	
	

}



