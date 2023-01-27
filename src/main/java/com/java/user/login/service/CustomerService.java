package com.java.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.user.login.model.Customer;
import com.java.user.login.repository.CustomerRepositoryIntface;



@Service
public class CustomerService {


	@Autowired
	CustomerRepositoryIntface customerRepository;
	
	
	public Customer register(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	
	public Customer getCustomerInfo(String userName) {
		
		return customerRepository.findByUserName(userName);
		
	}
	
	
}
