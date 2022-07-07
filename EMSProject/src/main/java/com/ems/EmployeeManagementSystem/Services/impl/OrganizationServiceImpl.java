package com.ems.EmployeeManagementSystem.Services.impl;

import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payloads.OrganizationDto;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepo;
import com.ems.EmployeeManagementSystem.Services.OrganizationService;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl  implements OrganizationService {
    @Autowired
    private OrganizationRepo organizationRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization org = this.modelMapper.map(organizationDto, Organization.class);
        Organization addedOrg = this.organizationRepo.save(org);
        return this.modelMapper.map(addedOrg, OrganizationDto.class);
    }
    @Override
    public OrganizationDto updateOrganization(OrganizationDto organizationDto, Integer orgId) {
        Organization org = this.organizationRepo.findById(orgId).orElseThrow(()-> new ResourceNotFoundException("Organization ","Organization Id",orgId));
        org.setOrganizationName(organizationDto.getOrganizationName());
        org.setOrganizationDiscription(organizationDto.getOrganizationDiscription());
        Organization updatedOrg = this.organizationRepo.save(org);
        return this.modelMapper.map(updatedOrg, OrganizationDto.class);
    }
    @Override
    public OrganizationDto getOrganization(Integer orgId) {
        Organization org = this.organizationRepo.findById(orgId).orElseThrow(()-> new ResourceNotFoundException("Organization ","Organization Id",orgId));
        return this.modelMapper.map(org, OrganizationDto.class);
    }
    @Override
    public List<OrganizationDto> getAllOrganization() {
        List<Organization> organizations = this.organizationRepo.findAll();
        List<OrganizationDto> organizationDtos = organizations.stream().map((organization)->this.modelMapper.map(organization, OrganizationDto.class)).collect(Collectors.toList());
        return organizationDtos;
    }
}
