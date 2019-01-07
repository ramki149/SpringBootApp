package com.in28minutes.Springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.Employee;
import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.EmployeeService;

/*
 * Jackson data bind - Can be used to convert JSON to OBJECT and OBJECT to JSON.
 * starter-web has this dependency added.
 * 
 * REST requires Client and Server. Two should be seperate system
 */

@RestController
public class EmployeeSearchController
{
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value = "/EmployeeSearch/{empId}", method = RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable String empId, ModelMap model) {
		return empService.getEmployee(empId);
	}
	
}