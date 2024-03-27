package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.clear.table.StudentData;
import com.jdc.tls.dao.StudentDao;
import com.jdc.tls.dto.Student;
import com.jdc.tls.dto.Student.Gender;
import com.jdc.tls.manager.ConnectionManager;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InsertTest {
	
	private StudentDao studentDao;
	
	@BeforeAll
	public static void beforeAllTest() {
	//	System.out.println("Before All Test");
		var stu = new StudentData(ConnectionManager.getInstance());
		stu.deletTableData();
	}
	
	@BeforeEach
	public void beforeEachTest() {
		System.out.println("Before Each");
		studentDao = new StudentDao(ConnectionManager.getInstance());
	}
	
	@Test
	@Order(1)
	public void testName() {
		var student = new Student("Hmue", Gender.Female);
		Student stu = studentDao.insertStudent(student);
		
		assertEquals("Hmue",stu.name() );
		assertEquals(Gender.Female, stu.gender());
	}
	
	@Test
	@Order(2)
	public void testGender() {
		//System.out.println("This is Test Two");
	}
	
	

}
