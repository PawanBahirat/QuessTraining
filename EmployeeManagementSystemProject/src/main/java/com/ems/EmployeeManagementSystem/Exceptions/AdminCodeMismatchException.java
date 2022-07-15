package com.ems.EmployeeManagementSystem.Exceptions;

public class AdminCodeMismatchException extends RuntimeException{
    private String message;
    public AdminCodeMismatchException(String message) {
        super(message);
        this.message=message;
    }
}
