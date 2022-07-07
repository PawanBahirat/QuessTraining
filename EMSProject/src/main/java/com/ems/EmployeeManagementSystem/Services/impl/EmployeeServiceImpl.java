package com.ems.EmployeeManagementSystem.Services.impl;

import com.ems.EmployeeManagementSystem.Entities.Role;
import com.ems.EmployeeManagementSystem.Exceptions.EmployeeRoleException;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payloads.EmployeeDto;
import com.ems.EmployeeManagementSystem.Repositories.EmployeeRepo;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepo;
import com.ems.EmployeeManagementSystem.Services.EmployeeService;
import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private OrganizationRepo organizationRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto, Integer orgId) {
        Organization organization = this.organizationRepo.findById(orgId).orElseThrow(()-> new ResourceNotFoundException("Organization","Organization Id ",orgId));
        Employee employee = this.modelMapper.map(employeeDto,Employee.class);
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());
        employee.setAge(employee.getAge());
        employee.setPassword(employee.getPassword());
        employee.setEmail(employee.getEmail());
        employee.setOrganization(organization);
        Employee newEmployee = this.employeeRepo.save(employee);
        return this.modelMapper.map(newEmployee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> allEmployees = this.employeeRepo.findAll();
        List<EmployeeDto> employeeDtos = allEmployees.stream().map((employee) -> this.modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto getEmployeeById(Integer employeeId) {
        Employee  employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",employeeId));
        return this.modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id", employeeId));
        this.employeeRepo.delete(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id", employeeId));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setAge(employeeDto.getAge());
        employee.setPassword(employeeDto.getPassword());
        employee.setEmail(employeeDto.getEmail());

        Employee updatedEmployee = this.employeeRepo.save(employee);
        return this.modelMapper.map(updatedEmployee,EmployeeDto.class);
    }

    @Override
    public void adminSetRole(Integer id, Role role) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));

        if(role.getName().equals("ROLE_ADMIN")) {
            Role role1 = new Role ();
            role1.setId(2);
            role1.setName("ROLE_ADMIN");
            Set<Role> Role = new HashSet<>();
            Role.add(role1);
            employee.setRoles(Role);
            employeeRepo.save(employee);

        }else if (role.getName().equals("ROLE_NORMAL")) {
            System.out.println("NORMAL USER");
            throw new EmployeeRoleException("Role is NORMAL ");
        }	else {
            System.out.println("Invalid Id");
            throw new EmployeeRoleException("Invalid logged in Id!!");
        }
    }
}
