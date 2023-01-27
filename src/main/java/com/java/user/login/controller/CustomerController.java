package com.java.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.user.login.model.Customer;
import com.java.user.login.service.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	
	@PostMapping("/customerInfo")
	public void fetchCustomerInfo(@RequestParam("userName") String userName) {
		
		Customer cust= customerService.getCustomerInfo(userName);
		
		System.out.println("Customer Id is "+cust.getId());
		
		
		
	}
	
	@PostMapping("/register")
	public Customer customerRegister(@RequestBody Customer customer) {
		
		System.out.println("Customer details "+customer.getCustomerName());
		
		Customer cust= customerService.register(customer);
		
		System.out.println("Customer Id is "+cust.getId());
		
		return cust;
		
		
		
	}

}
