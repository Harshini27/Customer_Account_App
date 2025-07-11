package com.fdmgroup.AccountAndCustomerManagement.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value ="Person")
public class Person extends Customer {

}
