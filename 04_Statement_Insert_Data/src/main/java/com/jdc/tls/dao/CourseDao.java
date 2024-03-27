package com.jdc.tls.dao;

import com.jdc.tls.con.manager.ConnectionManager;
import com.jdc.tls.dto.Course;

public class CourseDao {
	
	private ConnectionManager manager;
	
	public CourseDao(ConnectionManager manager) {
		this.manager = manager;
	}
	
	public int insertCourse(Course course) {
		
		var sql = "insert into course (title,level) values('%s','%s')"
				.formatted(course.courseName(),course.level());
		
		try(var con = manager.getConnection()) {
			
			var stat = con.createStatement();
			return stat.executeUpdate(sql);
			
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return 0;
	}

}
