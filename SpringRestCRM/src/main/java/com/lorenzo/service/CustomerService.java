package com.lorenzo.service;

import java.util.List;

import com.lorenzo.models.Customer;

public interface CustomerService {
	Customer findById(long id) throws Exception;
	Customer save(Customer customer);
	List<Customer> findAll();
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
	Customer findByEmail(String email);
}
