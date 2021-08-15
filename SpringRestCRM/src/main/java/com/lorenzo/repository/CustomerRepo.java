package com.lorenzo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	//Custom Queries
	List<Customer> findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
	Customer findByEmail(String email);
}
