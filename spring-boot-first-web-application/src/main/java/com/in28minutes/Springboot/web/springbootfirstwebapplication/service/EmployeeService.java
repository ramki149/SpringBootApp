package com.in28minutes.Springboot.web.springbootfirstwebapplication.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService
{
	private static final Map<Integer, Employee> empDatabase = new HashMap<Integer, Employee>();

	//Preload some employees
	static
	{
		Employee e = new Employee("ram", 111, new Date());
		empDatabase.put(e.getEmpId(), e);
		e = new Employee("kar", 222, new Date());
		empDatabase.put(e.getEmpId(), e);
		e = new Employee("dil", 333, new Date());
		empDatabase.put(e.getEmpId(), e);
	}

	public boolean addEmployee(String name, int empId, Date dob) {
		empDatabase.put(empId, new Employee(name, empId, dob));
		return true;
	}	

	public boolean addEmployee(String name, String empId, Date dob) {
		try {
			int eid = Integer.parseInt(empId);
			return addEmployee(name, eid, dob);
		}catch(NumberFormatException nfe) {
			nfe.printStackTrace();
			//Exception
		}

		return false;
	}
	
	public Employee getEmployee(int empId) {
		return empDatabase.get(empId);
	}
	
	public Employee getEmployee(String empId) {
		try {
			return getEmployee(Integer.parseInt(empId));
		}catch(NumberFormatException nfe) {
			//Not a valid Int
		}
		
		return null;
	}

	public List<Employee> getEmployees(){
		return empDatabase.values().stream().collect(Collectors.toList()); //Java 8
	}
	
}