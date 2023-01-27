package com.java.user.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.user.login.model.Customer;

@Repository
public interface CustomerRepositoryIntface extends JpaRepository<Customer, Integer> {
	
	
	public Customer findByUserName(String userNmae);
	

}
