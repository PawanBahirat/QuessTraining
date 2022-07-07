package com.ems.EmployeeManagementSystem.Services;

import com.ems.EmployeeManagementSystem.Payloads.OrganizationDto;

import java.util.List;

public interface OrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);

    OrganizationDto updateOrganization(OrganizationDto organizationDto, Integer orgId);

    OrganizationDto getOrganization(Integer orgId);

    List<OrganizationDto> getAllOrganization();
}
