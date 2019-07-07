package com.tokenGenerator.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private int custId;
	private String name;
	private int age;
	private int yearsOfBond;
	@OneToOne
	@JoinColumn(name = "token_id")
	private Token token;

	public Customer() {

	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getYearsOfBond() {
		return yearsOfBond;
	}

	public void setYearsOfBond(int yearsOfBond) {
		this.yearsOfBond = yearsOfBond;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	

}
