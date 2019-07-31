package com.learning.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.angular.model.Customer;
import com.learning.angular.model.Product;
import com.learning.angular.repository.CustomerRespository;
import com.learning.angular.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRespository customerRespository;
	
	@Autowired
	private CustomerService customerService;
	
	public Product addproduct(long customerId, Product product) {
		
		Customer customer  = customerService.findById(customerId);
		Product product2  = productRepository.save(new Product(product.getName(),customer));
		//customer.getProducts().add(new Product(product.getId(),product.getName()));
		return product2;
	}

	public List<Product> getProducts(long customerId) {
		// TODO Auto-generated method stub
		return productRepository.findByCustomerId(customerService.findById(customerId));
	}
}
