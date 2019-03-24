package com.yilmazmehmet.rentraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilmazmehmet.rentraapi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
