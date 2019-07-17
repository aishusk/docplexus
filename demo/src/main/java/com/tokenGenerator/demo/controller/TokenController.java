package com.tokenGenerator.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokenGenerator.demo.model.Customer;
import com.tokenGenerator.demo.model.Token;
import com.tokenGenerator.demo.services.CustomerServiceImpl;
import com.tokenGenerator.demo.services.TokenServiceImpl;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "tokens")
public class TokenController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	TokenServiceImpl tokenService;

	@Autowired
	CustomerServiceImpl customerService;

	private static int priority = 1;

	private int counter = 3;
	private static final String defaultStatus = "pending";
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/createTokens/{custId}")
	public Customer createTokens(@PathVariable("custId") int custId) {
		Optional<Customer> customer = customerService.getCustomerById(custId);
		if (customer == null) {
			return null;
		} else {
			Token token = new Token();
			token.setBankCounters(0);
			if (customer.get().getAge() > 60 || customer.get().getYearsOfBond() > 10) // check for privileged customer
			{
				token.setPriority(priority++);
			} 
			token.setStatus(defaultStatus); // initially token status set to pending
			tokenService.insert(token);
			customer.get().setToken(token); // setting the token value to the customer
			;
			logger.info("token is created for customer" + custId);
			customerService.insert(customer.get());
			/*
			 * return
			 * Response.ok().entity(customer.get()).header("Access-Control-Allow-Methods",
			 * "GET, POST, DELETE, PUT") .allow("OPTIONS").build();
			 */
			return customer.get();
		}
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getTokenById/{id}")
	public Optional<Token> getToken(@PathVariable("id") int id) {
		return tokenService.getTokenById(id);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/assignToken")
	public List<Token> assignTokenToCounter() {
		List<Token> remainingTokens = tokenService.getWaitingList(); // getWaitingList() function returns the list with
		List<Token> remainingPriorityCustomers= tokenService.getPriorityCustomers();
		
		remainingPriorityCustomers.addAll(remainingTokens);
		
		for (Token token : remainingPriorityCustomers) {
			if (counter != 0) {
				token.setBankCounters(counter--); // setting bank counter to customer with token#id
				token.setStatus("assigned"); // changing the token status to assigned after it is assigned to bank
												// counter
				tokenService.update(token.getToken_id()); // updating the token status in db
				logger.info(token.getToken_id() + "is assigned");
			} else {
				break;
			}
		}

		counter = 3; // resetting the bank counter value
		return remainingPriorityCustomers;
	}

}
