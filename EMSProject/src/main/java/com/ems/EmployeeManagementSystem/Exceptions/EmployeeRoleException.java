package com.ems.EmployeeManagementSystem.Exceptions;

public class EmployeeRoleException extends RuntimeException{
	
	String message;

	public EmployeeRoleException(String message) {
		super(String.format("%s", message));
		this.message = message;
	}
	
	

}
