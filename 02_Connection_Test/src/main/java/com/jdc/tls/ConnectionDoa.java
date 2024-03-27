package com.jdc.tls;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionDoa {
	
	private final String URL = "jdbc:mysql://localhost:3306/STUDENT_DB";
	private String sql = "Select name from COURSE;";
	
	public Integer getCourses(){
		
		var pro = new Properties();
		pro.put("user", "root");
		pro.put("password", "ThantLwinSoe@123");
		
		List<String> list = new ArrayList<String>();
		
		
		try(
				var con = DriverManager.getConnection(URL,pro);
				var statement = con.createStatement();
				) {
			
			var rs = statement.executeQuery(sql);
			
			
			
			while(rs.next()) {
				var name = rs.getString(1);
				
				list.add(name);
				
			}
			return list.size();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		
		return 0;
	}

}
