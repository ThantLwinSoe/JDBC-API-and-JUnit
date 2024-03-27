package com.jdc.tls.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.tls.con.manager.ConnectionManager;
import com.jdc.tls.dao.CourseDao;
import com.jdc.tls.dto.Course;
import com.jdc.tls.dto.Course.CourseLevel;

public class InsertTest {
	
	private CourseDao dao;
	
	@BeforeAll
	public static void beforeAllTest() {
		
	}
	
	@BeforeEach
	public void beforeEach() {
		 dao = new CourseDao(ConnectionManager.getInstance());
	}
	
	@Test
	public void testInsert() {
		
		var course = new Course("Java Basic",CourseLevel.Basic);
		
		
		int result = dao.insertCourse(course);
		assertEquals(1, result);
	}

}
