package com.crud.CrudOperations.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    private Integer studentId;
    public StudentNotFoundException(Integer studentId) {
        super(String.format("Student not found with id %s",studentId));
        this.studentId = studentId;
    }
}
