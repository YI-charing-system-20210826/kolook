package com.example.security.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSelectService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> searchAll() {
		return customerRepository.findAll();
	}
}