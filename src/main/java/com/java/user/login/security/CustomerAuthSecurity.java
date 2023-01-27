package com.java.user.login.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.java.user.login.repository.CustomerRepositoryIntface;


@Configuration
@EnableWebSecurity
public class CustomerAuthSecurity {

	
	
	@Autowired
	CustomerAuthenticationProvider  customerAuthenticationProvider;
	
	@Bean
	 public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		System.out.println("Insdie CustomerAuthSecurity -- configure");
		
		  
		http.cors().and().csrf().disable()
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.authorizeRequests()
		.antMatchers("/customerInfo").authenticated()
		.antMatchers("/register").permitAll()
		.and()
		.httpBasic();
		
		return http.build();
		
	}
	
	
	
	public void configure(AuthenticationManagerBuilder builder)
	          throws Exception {
		System.out.println("Insdie CustomerAuthSecurity -- configure - builder");
	      builder.authenticationProvider(customerAuthenticationProvider);
	  }
	  
	
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	      //PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	      return new BCryptPasswordEncoder() ;
	
	 }
}
