package com.in28minutes.Springboot.web.springbootfirstwebapplication.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity //This tells hibernate to make a table out of this class
@Table(name="employee")
public class Employee
{
	
	@Size(min=3, max=10, message="Min 3 and Max 10 chars")
	@Column(name="name")
	private String empName;
	
	@Column(name="id")
	@Id
	private int empId;
	
	@Column(name="dob")
	private Date dob;
	
	public Employee() {
	}

	public Employee(String name, int empId, Date dob) {
		this.empName = name;
		this.empId = empId;
		this.dob = dob;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpId() {
		return empId;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setEmpName(String name) {
		this.empName = name;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", dob=" + dob  + "]";
	}
}