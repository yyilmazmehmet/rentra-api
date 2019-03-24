package com.yilmazmehmet.rentraapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.Customer;
import com.yilmazmehmet.rentraapi.service.CustomerService;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class CustomerContoller {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")  
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

			Customer addedCustomer = customerService.addCustomer(customer);
			return ResponseEntity.ok(addedCustomer);

	}
	
	@GetMapping("/customer") 
	public ResponseEntity<List<Customer>> getAllCustomer() {

		List<Customer> customerList = customerService.getAllCustomer();

		if (customerList.isEmpty()) {

			throw new NoSuchEntityFoundException("Customers not found");
		}


		return ResponseEntity.ok(customerList);
	}
	
	


}
