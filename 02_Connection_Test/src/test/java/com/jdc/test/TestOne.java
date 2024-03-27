package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jdc.tls.ConnectionDoa;

public class TestOne {
	
	@Test
	public void test() {
		var dao = new ConnectionDoa();
		var size = dao.getCourses();
		
		assertEquals(5, size);
	}

}
