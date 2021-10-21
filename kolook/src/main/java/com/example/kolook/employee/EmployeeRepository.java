package com.example.kolook.employee;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.kolook.employee.domain.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
    public Employee findByUsername(String last_name);
    public List<Employee> findAll();

}