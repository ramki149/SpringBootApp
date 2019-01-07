package com.in28minutes.Springboot.web.springbootfirstwebapplication.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) //This needed when you use @Mock
public class EmployeeServiceTests
{
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void testAddEmployee() {
		
		//Mokito objects can never call original class methods
		
//		Mockito.when(employeeService.addEmployee("ram", "123", new Date())).thenReturn(true);
//		Mockito.when(employeeService.addEmployee("ram", "fff", new Date())).thenReturn(false);
//		assertTrue(employeeService.addEmployee("ram", "123", new Date()));
	}
	
	public void testListMokito() {
		List<Integer> mockList = Mockito.mock(List.class);
		
		Mockito.when(mockList.get(Mockito.anyInt())).thenReturn(10).thenReturn(20).thenReturn(30);
		assertEquals(new Integer(10), mockList.get(1));
	}

}