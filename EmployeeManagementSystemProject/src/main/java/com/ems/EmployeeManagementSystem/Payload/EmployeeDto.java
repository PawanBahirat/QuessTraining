package com.ems.EmployeeManagementSystem.Payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "employee")
public class EmployeeDto {

    private Integer id;
    @NotBlank
    @Size(min = 3,max=10,message = "First name must be length of 3-10 characters")
    private String firstName;
    @NotBlank
    @Size(min = 3,max=10,message = "Last name must be length of 3-10 characters")
    private String lastName;
    @NotBlank
    @Pattern(regexp = "[a-z0-9]+@[a-z]+[.]+[a-z]{2,3}", message = "Invalid Email ... !")
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message ="Password must contains : At least one upper case English letter, At least one lower case English letter, At least one digit, At least one special character, Minimum eight in length.")
    private String password;
    /*
        At least one upper case English letter, (?=.*?[A-Z])
        At least one lower case English letter, (?=.*?[a-z])
        At least one digit, (?=.*?[0-9])
        At least one special character, (?=.*?[#?!@$%^&*-])
        Minimum eight in length .{8,} (with the anchors)
    */
    @NotBlank
    @Pattern(regexp = ("^$|[0-9]{10}"),message = "Invalid phone number")
    private String phoneNumber;
    @NotNull
    @Range(min = 5000,max = 200000,message = "Salary should be from 10000-100000")
    private Integer salary;
    private RoleDto role;
    private OrganizationDto organization;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String adminCode;
}