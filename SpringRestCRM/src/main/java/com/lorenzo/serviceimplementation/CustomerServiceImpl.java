package com.lorenzo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.models.Customer;
import com.lorenzo.repository.CustomerRepo;
import com.lorenzo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer findById(long id) throws Exception{
		return customerRepo.findById(id).orElseThrow(() -> new Exception("Ticket with ID: " + id + "is not found"));
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public List<Customer> findByFirstName(String firstName) {
		return customerRepo.findByFirstName(firstName);
	}

	@Override
	public List<Customer> findByLastName(String lastName) {
		return customerRepo.findByLastName(lastName);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepo.findByEmail(email);
	}
	
	
	
	
	
}
