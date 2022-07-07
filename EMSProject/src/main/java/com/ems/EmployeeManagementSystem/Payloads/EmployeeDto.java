package com.ems.EmployeeManagementSystem.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;


@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Integer employeeId;
    @Pattern(regexp="^[a-zA-Z ]{3,}",message="length must be atleast 3")
    private String firstName;
    @Pattern(regexp="^[a-zA-Z ]{3,}",message="length must be atleast 3")
    private String lastName;
//    @Size(min = 18, max = 80, message = "Age must be between 18 - 80")
    private String age;
    @Pattern(regexp = "[a-z0-9]+@[a-z]+[.]+[a-z]{2,3}", message = "Invalid Email !!")
    private String email;
    private String password;
}
