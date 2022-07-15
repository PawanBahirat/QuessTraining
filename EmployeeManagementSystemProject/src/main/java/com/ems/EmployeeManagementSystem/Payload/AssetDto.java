package com.ems.EmployeeManagementSystem.Payload;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "asset")
public class AssetDto {

    private Integer id;
    @NotBlank
    private String name;
    private String issuedOn;
    private String expireOn;
    private OrganizationDto organization;
}
