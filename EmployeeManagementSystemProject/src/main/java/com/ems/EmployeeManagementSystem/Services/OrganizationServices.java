package com.ems.EmployeeManagementSystem.Services;

import com.ems.EmployeeManagementSystem.Payload.OrganizationDto;
public interface OrganizationServices {
    OrganizationDto saveOrganization(OrganizationDto organizationDto, Integer id);
    OrganizationDto getOrganizationById(Integer id);
    OrganizationDto updateOrganization(Integer id,OrganizationDto organizationDto);
//    void deleteOrganization(Integer id);
}