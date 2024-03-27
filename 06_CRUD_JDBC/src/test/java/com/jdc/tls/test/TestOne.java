package com.jdc.tls.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.tls.dto.ConnectionManager;
import com.jdc.tls.dto.Employee;
import com.jdc.tls.dto.EmployeeDao;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOne {
	
	private EmployeeDao dao;
	
	@BeforeAll
	public static void testBeforeAll() {
		var clear = new ClearringForTest(ConnectionManager.getInstance());
		clear.clearTableData();
	}
	
	@BeforeEach
	public void testBeforeEach() {
		dao = new EmployeeDao(ConnectionManager.getInstance());
	}
	
	@Test
	@Order(1)
	public void insertEmployee() {
		var emp = new Employee("Thet", "09876543");
		var testEmp = dao.insertEmployee(emp);
		
		assertEquals(emp.name(), testEmp.name());
		assertEquals(emp.phoneNumber(), testEmp.phoneNumber());
		assertEquals(1, testEmp.id());
	}
	
	@Test
	@Order(2)
	public void employeeNotNull() {
		var emp = new Employee("Thet", "09876543");
		var testEmp = dao.insertEmployee(emp);
		assertNotNull(testEmp);
	}
	
	@Test
	@Order(3)
	public void updateEmployee() {
		assertEquals(1, dao.updateEmployee(2));
	}
	
	@Test
	@Order(4)
	public void notUpdateStudent() {
		assertEquals(0, dao.updateEmployee(3));
	}
	
	@Test
	@Order(5)
	public void searchFoundEmployee() {
		var emp = dao.searchEmployee(1);
		assertNotNull(emp);
	}
	
	@Test
	@Order(6)
	public void searchNotFoundEmployee() {
		var emp = dao.searchEmployee(9);
		assertNull(emp);
	}
	
	@Test
	@Order(7)
	public void deleteEmployeeById() {
		
		var result = dao.deleteById(1);
		
		assertEquals(1, result);
	}
	
	@Test
	@Order(8)
	public void deleteEmployeeNotFound() {
		
		var result = dao.deleteById(9);
		assertEquals(0, result);
	}
	
	@Test
	@Order(9)
	public void insertListOfEmployee() {
		
		var list = new ArrayList<Employee>();
		list.add(new Employee("Thurain","0912345"));
		list.add(new Employee("Thu","0912346"));
		list.add(new Employee("Kaung","0912347"));
		list.add(new Employee("Zaw","0912348"));
		
		int[] result = dao.insertListEmployee(list);
		
		int ok = Arrays.stream(result).sum();
		
		assertEquals(4, ok);
	}
	
	@Test
	@Order(10)
	public void nonInsertListOfEmployee() {
		
		var list = new ArrayList<Employee>();
		
		var result = dao.insertListEmployee(list);
		
		assertNull(result);
		
	}

}
