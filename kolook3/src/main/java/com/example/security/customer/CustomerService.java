package com.example.security.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class CustomerService implements UserDetailsService {


    @Autowired
    private CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	private List<Customer> result;


    @Override
    public Customer loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        Customer user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return user;
    }

    public List<Customer> findAllList() {
    	result = repository.findAll();
		return result;
	}


  
    @Transactional
    public void registerAdmin(String username, String password, String mailAddress) {
    	Customer user = new Customer(username,passwordEncoder.encode(password),mailAddress);

        user.setAdmin(true);
        repository.save(user);
    }

    @Transactional
    public void registerManager(String username, String password, String mailAddress) {
        Customer user = new Customer(username, passwordEncoder.encode(password), mailAddress);
        user.setManager(true);
        repository.save(user);
    }

    @Transactional
    public void registerUser(String username, String password, String mailAddress) {
        Customer user = new Customer(username, passwordEncoder.encode(password), mailAddress);
        repository.save(user);
    }

}
