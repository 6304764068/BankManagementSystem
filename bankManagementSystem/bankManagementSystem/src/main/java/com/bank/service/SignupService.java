package com.bank.service;

import java.util.List;

import com.bank.entity.Customer;

public interface SignupService {

	String validate(Customer customer);
	List<Customer> getCustomers();
	
}
