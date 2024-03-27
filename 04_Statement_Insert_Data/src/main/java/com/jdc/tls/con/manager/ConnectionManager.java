package com.jdc.tls.con.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManager {
	
	final String URL = "jdbc:mysql://localhost:3306/statement_db";
	final String USER = "root";
	final String PASS = "ThantLwinSoe@123";
	
	Connection getConnection() throws SQLException;
	
	public static ConnectionManager getInstance() {
		return () -> DriverManager.getConnection(URL,USER,PASS);
	}

}
