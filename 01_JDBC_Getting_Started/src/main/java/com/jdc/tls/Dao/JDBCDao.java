package com.jdc.tls.Dao;

import java.sql.DriverManager;

public class JDBCDao {
	
	private final String URL = "jdbc:mysql://localhost:3306/STUDENT_DB";
	private final String USERNAME = "root";
	private final String PASSWORD = "ThantLwinSoe@123";
	
	private String count = "select count(*) from COURSE;";
	
	public Long getCountCourse() {
		
		try(
				var con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				var statement = con.createStatement()
				){
			
			var resultSet = statement.executeQuery(count);
			
			if(resultSet.next()) {
				return resultSet.getLong(1);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return (long) 0;
	}

}
