package com.yilmazmehmet.rentraapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.Address;
import com.yilmazmehmet.rentraapi.model.Customer;
import com.yilmazmehmet.rentraapi.model.Phone;
import com.yilmazmehmet.rentraapi.repository.CustomerRepository;

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

}
