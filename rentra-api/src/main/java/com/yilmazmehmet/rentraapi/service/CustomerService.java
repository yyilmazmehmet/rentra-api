package com.yilmazmehmet.rentraapi.service;

import java.util.List;

import com.yilmazmehmet.rentraapi.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer updateCustomer(Customer customer);

}
