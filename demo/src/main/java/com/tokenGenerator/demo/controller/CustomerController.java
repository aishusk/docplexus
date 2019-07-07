package com.tokenGenerator.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokenGenerator.demo.model.Customer;
import com.tokenGenerator.demo.services.CustomerServiceImpl;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpl service;
	@PostMapping(value="/createCustomer")
	public String createCustomer(@RequestBody Customer customer)
	{
		service.insert(customer);		//creating new customers in db
		return "Customer with id "+customer.getCustId()+"is saved successfully";
	}
	@GetMapping(value="/getCustomerById/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") int id)
	{
		return service.getCustomerById(id);		//finding particular customer in db
	}
	
}
