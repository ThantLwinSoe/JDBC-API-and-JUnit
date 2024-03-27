package com.jdc.tls.dto;

public record Student(int id, String name,Gender gender ) {
	
	public Student(String name, Gender gender) {
		this(0,name,gender);
	}
	
	public Student cloneStudent(int id, String name,Gender gender) {
		return new Student(id, name, gender);
	}
	
	public enum Gender {
		Male,Female
	}

}
