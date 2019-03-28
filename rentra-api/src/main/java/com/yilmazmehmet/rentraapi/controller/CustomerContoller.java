package com.yilmazmehmet.rentraapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.Customer;
import com.yilmazmehmet.rentraapi.service.CustomerService;

@PreAuthorize("hasRole('ADMIN')")
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

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
			@RequestBody Customer customer) {
		Optional<Customer> optional = customerService.findCustomerById(customerId);

		if (!optional.isPresent()) {

			throw new NoSuchEntityFoundException("Customer Id not found" + customerId);

		} else {

			customer.setId(customerId);

			return ResponseEntity.ok(customerService.updateCustomer(customer));
		}

	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long customerId) {
		Optional<Customer> optional = customerService.findCustomerById(customerId);

		if (!optional.isPresent()) {

			throw new NoSuchEntityFoundException("Customer Id not found" + customerId);

		} else {

			customerService.deleteCustomer(customerId);
			return ResponseEntity.status(HttpStatus.OK)
					.body(" " + customerId.toString() + " id is successfully deleted.");
		}

	}

}
