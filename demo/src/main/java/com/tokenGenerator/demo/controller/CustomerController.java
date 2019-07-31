package com.tokenGenerator.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokenGenerator.demo.model.Customer;
import com.tokenGenerator.demo.services.CustomerServiceImpl;
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl service;
	
	@CrossOrigin(origins="*")
	@PostMapping(value="/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		service.insert(customer);		//creating new customers in db
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping(value="/getCustomerById/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") int id)
	{
		return service.getCustomerById(id);		//finding particular customer in db
	}
	
}
