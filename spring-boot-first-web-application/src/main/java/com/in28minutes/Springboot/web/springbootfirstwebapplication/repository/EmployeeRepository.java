package com.in28minutes.Springboot.web.springbootfirstwebapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.Employee;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete
public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{
	
}