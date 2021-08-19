package com.lorenzo.service;

import java.util.List;

import com.lorenzo.models.Product;

public interface ProductService {
	Product findById(Long id) throws Exception;
	Product save(Product product);
	void deleteById(Long id);
	Product findByProductName(String productName);
	List<Product> findAll();
}
