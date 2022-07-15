package com.ems.EmployeeManagementSystem.Services.ServicesImpl;

import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payload.OrganizationDto;
import com.ems.EmployeeManagementSystem.Repositories.EmployeeRepository;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepository;
import com.ems.EmployeeManagementSystem.Services.OrganizationServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServicesImpl implements OrganizationServices {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto, Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        Organization organization=modelMapper.map(organizationDto,Organization.class);
        Organization savedOrganization=organizationRepository.save(organization);
        employee.setOrganization(savedOrganization);
        employeeRepository.save(employee);
        return modelMapper.map(savedOrganization,OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationById(Integer id) {
        Organization organization=organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization","Organization Id",id));
        return modelMapper.map(organization,OrganizationDto.class);
    }

    @Override
    public OrganizationDto updateOrganization(Integer id, OrganizationDto organizationDto) {

        Organization existingOrganization=organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization","Organization Id",id));
        existingOrganization.setName(organizationDto.getName());
        existingOrganization.setOrgDisc(organizationDto.getOrgDisc());
        return modelMapper.map(organizationRepository.save(existingOrganization),OrganizationDto.class);
    }

//    @Override
//    public void deleteOrganization(Integer id) {
//        Organization organization=organizationRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Organization","Organization Id",id));
//        organizationRepository.delete(organization);
//    }
}
