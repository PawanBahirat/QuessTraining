package com.ems.EmployeeManagementSystem.Exceptions;

public class RoleNotAvailableException extends RuntimeException{
    private String message;
    public RoleNotAvailableException(String message) {
        super(message);
        this.message=message;
    }
}
