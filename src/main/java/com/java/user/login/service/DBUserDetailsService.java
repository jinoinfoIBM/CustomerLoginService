package com.java.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.user.login.model.Customer;
import com.java.user.login.model.SecureUser;
import com.java.user.login.repository.CustomerRepositoryIntface;

@Service
public class DBUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepositoryIntface customerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Customer customer = customerRepository.findByUserName(userName);
        if (customer == null) {
            throw new UsernameNotFoundException(userName);
        }
        return new SecureUser(customer);
    }
}


