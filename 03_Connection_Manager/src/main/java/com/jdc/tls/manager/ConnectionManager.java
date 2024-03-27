package com.jdc.tls.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManager {
	
	final String URL = "jdbc:mysql://localhost:3306/STUDENT_DB";
	final String user = "root";
	final String password = "ThantLwinSoe@123";
	
	Connection getConnection() throws SQLException;
	
	public static ConnectionManager getConnectionManager() {
		return () -> DriverManager.getConnection(URL, user, password);
	}

}
