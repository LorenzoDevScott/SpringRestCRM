package com.lorenzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorenzo.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	Product findByProductName(String productName);
}
