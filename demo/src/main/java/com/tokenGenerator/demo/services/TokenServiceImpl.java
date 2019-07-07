package com.tokenGenerator.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokenGenerator.demo.model.Token;
import com.tokenGenerator.demo.repository.TokenRepository;

@Service
public class TokenServiceImpl {

	@Autowired
	TokenRepository repository;
	String status="pending";
	public void insert(Token token)
	{
		repository.save(token);
	}
	public void deleteById(int id)
	{
		repository.deleteById(id);
	}
	public List<Token>getTokens()
	{
		return repository.findAll();
	}
	public Optional<Token> getTokenById(int id)
	{
		return repository.findById(id);
	}
	public List<Token> getWaitingList()
	{
		return repository.findWaitingCustomers();
	}
	public List<Token> getPriorityCustomers()
	{
		return repository.findPriorityWaitingCustomers();
	}
	public void update(int id)
	{
		repository.updateToken(id);
	}
	
}
