package com.in28minutes.Springboot.web.springbootfirstwebapplication.service;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaystubService
{
	private int empId;
	private int checkNo;
	private String date;
	private int salary;
	
	public PaystubService(){
		
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(int checkNo) {
		this.checkNo = checkNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "PaystubService [empId=" + empId + ", checkNo=" + checkNo + ", date=" + date + ", salary=" + salary
				+ "]";
	}	
}