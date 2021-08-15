package com.lorenzo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lorenzo.models.Product;
import com.lorenzo.repository.ProductRepo;
import com.lorenzo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product findById(Long id) throws Exception {
		return productRepo.findById(id).orElseThrow(() -> new Exception("Product with ID: " + id + "is not found"));
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	
	
	
	
	

}
