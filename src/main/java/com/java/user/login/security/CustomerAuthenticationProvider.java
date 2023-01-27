package com.java.user.login.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.java.user.login.model.Customer;
import com.java.user.login.repository.CustomerRepositoryIntface;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {
	
	
	private CustomerRepositoryIntface customerRepository;
	/*
	private PasswordEncoder passwordEncoder;
	
	CustomerAuthenticationProvider (CustomerRepositoryIntface customerRepository, PasswordEncoder encoder){
		
		this.customerRepository= customerRepository;
		this.passwordEncoder= encoder;
		
	}*/

	@Override
	public Authentication authenticate(Authentication authentication)throws AuthenticationException{
		
		System.out.println("Inside authenticate... username "+authentication.getName());
		
		String userName= authentication.getName();
		
		
		
		String password = authentication.getCredentials().toString();
		
		System.out.println("Inside authenticate..username .."+userName +" password .."+password);
		
		Optional<Customer> optional = Optional.ofNullable(customerRepository.findByUserName(userName));
		
		System.out.println("Inside authenticate .. Optional "+optional);
		
		if(!optional.isPresent()) {
			throw new BadCredentialsException("Details not found");
		}
		
		/*
		 * if(passwordEncoder.matches(password, optional.get().getPassword())) {
		 * 
		 * 
		 * System.out.println("Successfully Authenticated");
		 * 
		 * return new UsernamePasswordAuthenticationToken(userName, password); }else {
		 * 
		 * throw new BadCredentialsException("Password mismatch"); }
		 */
		
		return new UsernamePasswordAuthenticationToken(userName, password); 
		
		//return new UsernamePasswordAuthenticationToken(userName, password,aList);
	}
	
	
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	
}
