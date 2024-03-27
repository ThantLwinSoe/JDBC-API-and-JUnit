package com.jdc.tls.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.tls.CoursesFromDB;
import com.jdc.tls.manager.ConnectionManager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCourseCount {
	
	@BeforeAll
	public static void beforeAllTest() {
		System.out.println("Before All test");
	}
	
	@AfterAll
	public static void afterAllTest() {
		System.out.println("After All test");
	}
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("Before each test!!!");
	}
	
	@AfterEach
	public void afterEachTest() {
		System.out.println("After each test!!!");
	}
	
	@Test
	@Order(1)
	public void countTest() {
		var dao = new CoursesFromDB(ConnectionManager.getConnectionManager());
		
		var num = dao.getCoursesNumber();
		System.out.println("Test One");
		
		assertEquals(5, num);
		
	}
	
	@Test
	@Order(2)
	public void TestTwo() {
		System.out.println("Test Two");
	}
	
	@Test
	@Order(3)
	public void TestThree() {
		System.out.println("Test Three");
	}
	

}
