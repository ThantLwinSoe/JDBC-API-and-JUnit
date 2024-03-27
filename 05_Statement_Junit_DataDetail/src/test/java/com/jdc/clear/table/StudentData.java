package com.jdc.clear.table;

import java.sql.SQLException;

import com.jdc.tls.manager.ConnectionManager;

public class StudentData {
	
	private ConnectionManager manager;
	
	
	public StudentData(ConnectionManager manager) {
		this.manager = manager;
	}
	
	public int deletTableData() {
		
		var sql = "truncate table student";
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			
			return stat.executeUpdate(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

}
