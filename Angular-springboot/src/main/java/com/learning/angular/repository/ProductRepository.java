package com.learning.angular.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.angular.model.Customer;
import com.learning.angular.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("select p from Product p where p.customer = ?1")
	List<Product> findByCustomerId(Customer c);
}
