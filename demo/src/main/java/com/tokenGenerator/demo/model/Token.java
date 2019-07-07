package com.tokenGenerator.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Token {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int token_id;
	private int bankCounters;
	private String status;
	public int priority=0;
	
	
	public Token() {
		
	}
	
	public int getToken_id() {
		return token_id;
	}
	public void setToken_id(int token_id) {
		this.token_id = token_id;
	}
	public int getBankCounters() {
		return bankCounters;
	}
	public void setBankCounters(int bankCounters) {
		this.bankCounters = bankCounters;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	

}
