package com.lorenzo.serviceimplementation;

import java.util.List;
import java.util.Optional;

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
	public Customer findById(Long id) throws Exception{
		
			if(customerRepo.findById(id).isPresent()) {
				return (Customer) customerRepo.findById(id).get();
			} else {
				return null;
			}
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		customerRepo.deleteById(id);
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
