package com.ems.EmployeeManagementSystem.Exceptions;

public class EmailNotFoundException extends RuntimeException{
    private String message;
    public EmailNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
