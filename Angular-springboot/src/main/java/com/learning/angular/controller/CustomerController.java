package com.learning.angular.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.angular.model.Customer;
import com.learning.angular.model.Product;
import com.learning.angular.repository.CustomerRespository;
import com.learning.angular.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
		
	@PostMapping("/customers/create")
	public Customer addCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.addCustomer(customer); 
		return cust;
	}
	
	@RequestMapping("/customers")
	public List<Customer> getCustomer(){
		return customerService.getCustomer();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") long id) {
		return customerService.findById(id);
 	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<>("customer has been deleted",HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomer(){
		customerService.deleteAllCustomer();
		return new ResponseEntity<>("All customer has been deleted", HttpStatus.OK);
	}
	
	@GetMapping("customers/age/{age}")
	public List<Customer> findByAge(@PathVariable("age") int age){
		List<Customer> customer = customerService.findByAge(age);
		return customer;
	}
	
	@GetMapping("customers/name/{name}")
	public List<Customer> findByName(@PathVariable("name") String name){
		List<Customer> customer = customerService.findByName(name);
		return customer;
	}
	
	@GetMapping("customers/nameAndAge/{name}/{age}")
	public List<Customer> findByNameAndAge(@PathVariable("name") String name, @PathVariable("age") int age){
		List<Customer> customer = customerService.findByNameAndAge(name,age);
		return customer;
	}
	
	@GetMapping("customers/startChar/{chr}")
	public List<Customer> findByStartingCharacter(@PathVariable("chr") String chr){
		List<Customer> customer = customerService.findByStartingCharacter(chr);
		return customer;
	} 
	
	@PutMapping("customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
		 Customer customerData = customerService.findById(id);
		 if(customerData != null) {
			 customerData.setName(customer.getName());
			 customerData.setActive(customer.isActive());
			 customerData.setAge(customer.getAge());
			 return new ResponseEntity<>(customerService.updateCustomer(customerData),HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
}
