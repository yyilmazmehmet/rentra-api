package com.yilmazmehmet.rentraapi.service;

import java.util.List;
import java.util.Optional;

 import com.yilmazmehmet.rentraapi.model.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer updateCustomer(Customer customer);
	Optional<Customer> findCustomerById(Long id);
	Boolean deleteCustomer(Long id);
 
}
