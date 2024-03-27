package com.jdc.tls.dto;

public record Course(int id,String courseName , CourseLevel level) {
	
	public Course(String courseName,CourseLevel lvl) {
		this(0,courseName,lvl);
	}
	
	public enum CourseLevel{
		Basic,Intermediate,Advance;
		
		@Override
		public String toString() {
			return super.toString();
		}
		
	}

}
