package com.jdc.tls.dto;

public record Employee(int id, String name, String phoneNumber) {
	
	public Employee(String name, String phoneNumber) {
		this(0,name,phoneNumber);
	}
	
	public Employee cloneEmployee(int id, String name,String phoneNumber) {
		return new Employee(id,name,phoneNumber);
	}

}
