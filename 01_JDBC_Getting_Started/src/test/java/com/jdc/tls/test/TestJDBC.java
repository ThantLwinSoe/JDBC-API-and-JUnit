package com.jdc.tls.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jdc.tls.Dao.JDBCDao;

public class TestJDBC {
	
	@Test
	public void testOne() {
		
		var dao = new JDBCDao();
		var result = dao.getCountCourse();
		assertEquals(5, result);
	}

}
