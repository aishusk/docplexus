package com.learning.angular.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.angular.model.Customer;
import com.learning.angular.repository.CustomerRespository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRespository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(new Customer(customer.getName(), customer.getAge()));
	}

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers::add);
		for(Customer c : customers) {
			System.out.println(c);
		}
		return customers;
	}

	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

	public void deleteAllCustomer() {
		// TODO Auto-generated method stub
		customerRepository.deleteAll();
	}

	public List<Customer> findByAge(int age) {
		// TODO Auto-generated method stub
		return customerRepository.findByAge(age);
	}

	public List<Customer> findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName(name);
	}

	public List<Customer> findByNameAndAge(String name, int age) {
		// TODO Auto-generated method stub
		return customerRepository.findByNameAndAge(name,age);
	}

	public List<Customer> findByStartingCharacter(String chr) {
		// TODO Auto-generated method stub
		return customerRepository.findByStartingCharacter(chr);
	}

	public Customer findById(long id) {
		// TODO Auto-generated method stub
		Optional<Customer> customerData = customerRepository.findById(id);
		
		if(customerData.isPresent()) {
			return customerData.get();
		}
		else
			return null;
	}

	public Customer updateCustomer(Customer customerData) {
		// TODO Auto-generated method stub
		return customerRepository.save(customerData);
	}


	
}
