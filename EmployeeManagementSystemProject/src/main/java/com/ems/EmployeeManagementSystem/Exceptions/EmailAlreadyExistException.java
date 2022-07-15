package com.ems.EmployeeManagementSystem.Exceptions;

public class EmailAlreadyExistException extends RuntimeException{
    private String message;
    public EmailAlreadyExistException(String message) {
        super(message);
        this.message=message;
    }
}
