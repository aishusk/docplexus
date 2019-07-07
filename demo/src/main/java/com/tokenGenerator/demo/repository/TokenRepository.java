package com.tokenGenerator.demo.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tokenGenerator.demo.model.Token;
@Repository
public interface TokenRepository extends JpaRepository<Token,Integer>{
	@Query(value="select * from Token where status='pending' and priority>0 order by priority asc",nativeQuery=true)
	List<Token> findPriorityWaitingCustomers();
	
	@Query(value="select * from Token where status='pending' and priority=0 ", nativeQuery=true)
	List<Token> findWaitingCustomers();
	
	@Transactional
	@Modifying
	@Query(value="update Token set status='assigned' where token_id=:id" )
	void updateToken(@Param("id")int id);
}
