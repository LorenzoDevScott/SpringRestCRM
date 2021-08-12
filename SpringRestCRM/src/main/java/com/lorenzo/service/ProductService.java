package com.lorenzo.service;

import com.lorenzo.models.Product;

public interface ProductService {
	Product findById(Long id) throws Exception;
	Product save(Product product);
}
