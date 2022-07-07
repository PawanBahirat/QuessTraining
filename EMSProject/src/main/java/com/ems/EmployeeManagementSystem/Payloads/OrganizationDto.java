package com.ems.EmployeeManagementSystem.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrganizationDto {
    private Integer organizationId;
    private String organizationName;
    private String organizationDiscription;
}
