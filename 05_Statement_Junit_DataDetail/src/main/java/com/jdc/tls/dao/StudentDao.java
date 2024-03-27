package com.jdc.tls.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdc.tls.dto.Student;
import com.jdc.tls.manager.ConnectionManager;


public class StudentDao {
	
	private ConnectionManager manager;
	
	public StudentDao(ConnectionManager manager) {
		this.manager  = manager;
	}
	
	public Student insertStudent(Student student) {
		var sql = "insert into student (name,gender) values('%s','%s')"
				.formatted(student.name(),student.gender());
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet result = stat.getGeneratedKeys();
			
			if(result.next()) {
				var id = result.getInt(1);
				return student.cloneStudent(id, student.name(), student.gender());
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
