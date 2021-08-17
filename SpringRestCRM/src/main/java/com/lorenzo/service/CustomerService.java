package com.lorenzo.service;

import java.util.List;


import com.lorenzo.models.Customer;

public interface CustomerService {
	Customer findById(Long id) throws Exception;
	Customer save(Customer customer);
	void deleteById(Long id);
	List<Customer> findAll();
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
	Customer findByEmail(String email);
}
