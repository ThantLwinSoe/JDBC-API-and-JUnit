package com.jdc.tls.dto;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmployeeDao {
	
	private ConnectionManager manager;
	
	public EmployeeDao(ConnectionManager manager) {
		this.manager = manager;
	}
	
	// insert
	public Employee insertEmployee(Employee employee) {
		
		
		var sql = "insert into employee (name,phoneNumber) values( '%s','%s');"
				.formatted(employee.name(),employee.phoneNumber());
		
		try(var con = manager.getConnection();
				var stat = con.createStatement();) {
						
			stat.execute(sql,Statement.RETURN_GENERATED_KEYS);
				
			var rs = stat.getGeneratedKeys();
			
			if(rs.next()) {
			var  id = rs.getInt(1);
			
			return employee.cloneEmployee(id, employee.name(), employee.phoneNumber());
			  
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	// update
	public int updateEmployee(int id) {
		
		var sql = "update employee set name = 'Hmue', phoneNumber = '09123456' where id = '%s';"
				.formatted(id);
		
		try(var con = manager.getConnection()) {
			var stat = con.createStatement();
			
			return stat.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// search
	public Employee searchEmployee(int id) {
		
		var sql = "select * from employee where id = '%s';"
				.formatted(id);
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			var rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	//delete
	public int deleteById(int id) {
		
		var sql = "delete from employee where id = '%s';"
				.formatted(id);
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			
			int num = stat.executeUpdate(sql);
			
			return num;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public int[] insertListEmployee(List<Employee> list) {
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			
			if(list.isEmpty()) {
				return null;
			}
			
			for(var emp : list) {
				var sql = "insert into employee (name,phoneNumber) values( '%s','%s');"
						.formatted(emp.name(),emp.phoneNumber());
				
				stat.addBatch(sql);
			}
			
			return stat.executeBatch();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
