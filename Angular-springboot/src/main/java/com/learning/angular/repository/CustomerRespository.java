package com.learning.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.angular.model.Customer;

@Repository
public interface CustomerRespository extends CrudRepository<Customer, Long> {

	List<Customer> findByAge(int age);
	
	List<Customer> findByName(String name);

	List<Customer> findByNameAndAge(String name, int age);
	
	@Query("select c from Customer c where c.name like ?1%")
	List<Customer> findByStartingCharacter(String str);
	
	//Customer findById(long id);
}
