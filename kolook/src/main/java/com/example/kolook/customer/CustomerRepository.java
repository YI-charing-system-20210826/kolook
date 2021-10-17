package com.example.kolook.customer;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kolook.customer.domain.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    public Customer findByUsername(String username);
    public List<Customer> findAll();

}