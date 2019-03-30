package com.yilmazmehmet.rentraapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.Address;
import com.yilmazmehmet.rentraapi.model.Customer;
import com.yilmazmehmet.rentraapi.model.Phone;
import com.yilmazmehmet.rentraapi.repository.CustomerRepository;
import com.yilmazmehmet.rentraapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) {

		customerRepository.save(insertAdressAndPhoneToPerson(customer));

		return customer;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return customerRepository.save(insertAdressAndPhoneToPerson(customer));
	}

	private Customer insertAdressAndPhoneToPerson(Customer customer) {

		for (Address address : customer.getAddressList()) {
			address.setCustomer(customer);
			customer.getAddressList().add(address);
		}

		for (Phone phone : customer.getPhoneList()) {
			customer.getPhoneList().add(phone);
		}

		return customer;
	}

	@Override
	public Optional<Customer> findCustomerById(Long id) {

		return customerRepository.findById(id);
	}

	@Override
	public Boolean deleteCustomer(Long id) {
		
		customerRepository.deleteById(id);
		
		return true;
	}

}
