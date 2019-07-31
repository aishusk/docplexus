package com.tokenGenerator.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tokenGenerator.demo.model.Customer;
import com.tokenGenerator.demo.repository.CustomerRepository;

@Component
public class CustomerServiceImpl {
	@Autowired
	private CustomerRepository repository;

	public void insert(Customer customer)
	{
		repository.save(customer);
	}
	public void deleteById(int id)
	{
		repository.deleteById(id);
	}
	public List<Customer>getCustomers()
	{
		return repository.findAll();
	}
	
	public Optional<Customer> getCustomerById(int id)
	{
		return repository.findById(id);
	}
	
}
