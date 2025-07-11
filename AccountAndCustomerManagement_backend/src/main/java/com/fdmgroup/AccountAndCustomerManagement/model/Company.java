package com.fdmgroup.AccountAndCustomerManagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value ="Company")
public class Company extends Customer{

}
