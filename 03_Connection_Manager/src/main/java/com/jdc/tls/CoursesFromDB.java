package com.jdc.tls;

import java.sql.Connection;

import com.jdc.tls.manager.ConnectionManager;

public class CoursesFromDB {
	
	private final String SQL = "select count(*) from COURSE;";
	
	private ConnectionManager manager;
	
	public CoursesFromDB(ConnectionManager manager) {
		this.manager = manager;
	}
	
	public int getCoursesNumber(){
		
		try(Connection con = manager.getConnection()) {
			
			var statement = con.createStatement();
			var rs = statement.executeQuery(SQL);
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		return 0;
	}
}
