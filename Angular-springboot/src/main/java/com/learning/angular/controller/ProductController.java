package com.learning.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.angular.model.Product;
import com.learning.angular.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("customers/{customerId}/product")
	public Product addProduct(@PathVariable("customerId") long customerId, @RequestBody Product product) {
		return productService.addproduct(customerId, product);
	}
	
	@GetMapping("customers/{customerId}/product")
	public List<Product> getProducts(@PathVariable("customerId") long customerId){
		return productService.getProducts(customerId);
	}
}
