package com.yilmazmehmet.rentraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
