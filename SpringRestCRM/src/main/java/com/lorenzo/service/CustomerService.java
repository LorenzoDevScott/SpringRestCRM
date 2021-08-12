package com.lorenzo.service;

import com.lorenzo.models.Customer;

public interface CustomerService {
	Customer findById(long id) throws Exception;
	Customer save(Customer customer);
}
