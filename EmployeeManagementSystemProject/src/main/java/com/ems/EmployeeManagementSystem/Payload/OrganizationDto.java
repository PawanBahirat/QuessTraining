package com.ems.EmployeeManagementSystem.Payload;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "organization")
public class OrganizationDto {

    private Integer id;
    @NotBlank
    @Size(min=5,message = "Name should contain at least 5 chars.")
    private String name;
    @NotBlank
    @Size(min=10,message = "Disc should contain at least 10 chars.")
    private String orgDisc;
}
