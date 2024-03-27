package com.jdc.tls.test;

import java.sql.SQLException;

import com.jdc.tls.dto.ConnectionManager;

public class ClearringForTest {
	
	private ConnectionManager manager;
	
	public ClearringForTest(ConnectionManager manager) {
		this.manager = manager;
	}
	
	public void clearTableData() {
		
		var sql = "truncate table employee;";
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			stat.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
