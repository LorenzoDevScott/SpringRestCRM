package com.lorenzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
