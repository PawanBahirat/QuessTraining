package com.ems.EmployeeManagementSystem.Services.ServicesImpl;
import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import com.ems.EmployeeManagementSystem.Entities.Role;
import com.ems.EmployeeManagementSystem.Exceptions.AdminCodeMismatchException;
import com.ems.EmployeeManagementSystem.Exceptions.EmailAlreadyExistException;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Exceptions.RoleNotAvailableException;
import com.ems.EmployeeManagementSystem.Payload.EmployeeDto;
import com.ems.EmployeeManagementSystem.Payload.RoleDto;
import com.ems.EmployeeManagementSystem.Repositories.EmployeeRepository;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepository;
import com.ems.EmployeeManagementSystem.Repositories.RoleRepository;
import com.ems.EmployeeManagementSystem.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    public static final Integer ADMIN = 1;
    public static final Integer HR = 2;
    public static final Integer EMPLOYEE = 3;

    public static final String ADMIN_CODE="Pawan@123";

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto, Integer organizationId) {
        Organization organization =organizationRepository.findById(organizationId).orElseThrow(()->new ResourceNotFoundException("Organization","Organization Id",organizationId));
        if(employeeRepository.findByEmail(employeeDto.getEmail()).isPresent())
            throw new EmailAlreadyExistException("Email already exist");

        Employee employee=modelMapper.map(employeeDto,Employee.class);
        employee.setOrganization(organization);
        employee.setEmail(employeeDto.getEmail().toLowerCase());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Role role=new Role();
        role.setId(EMPLOYEE);
        role.setName("ROLE_EMPLOYEE");
        roleRepository.save(role);
        employee.setRole(role);
        return modelMapper.map(employeeRepository.save(employee),EmployeeDto.class);
    }


    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        List<EmployeeDto> employeeDtos=employees.stream().map(employee->modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setPhoneNumber(employeeDto.getPhoneNumber());

        if(!existingEmployee.getEmail().equalsIgnoreCase(employeeDto.getEmail())) {
            if(employeeRepository.findByEmail(employeeDto.getEmail()).isPresent()) throw new EmailAlreadyExistException("Email already exist.");
            existingEmployee.setEmail(employeeDto.getEmail().toLowerCase());
        }

        existingEmployee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        existingEmployee.setSalary(employeeDto.getSalary());
        return modelMapper.map(employeeRepository.save(existingEmployee),EmployeeDto.class);
    }
    @Override
    public String updateEmployeeRole(Integer id, RoleDto roleDto) {
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        if(roleDto.getName().equals("ROLE_EMPLOYEE")) {
            Role role=new Role();
            role.setId(EMPLOYEE);
            role.setName("ROLE_EMPLOYEE");
            roleRepository.save(role);
            existingEmployee.setRole(role);
            employeeRepository.save(existingEmployee);
            return "Employee id : "+ id +" updated as ROLE_EMPLOYEE";
        }
        else if (roleDto.getName().equals("ROLE_HR")) {
            Role role=new Role();
            role.setId(HR);
            role.setName("ROLE_HR");
            roleRepository.save(role);
            existingEmployee.setRole(role);
            employeeRepository.save(existingEmployee);
            return "Employee id : "+ id +" updated as ROLE_HR";
        }
        else throw new RoleNotAvailableException("Role \""+roleDto.getName()+ "\" is not available");
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        employeeRepository.delete(employee);
    }

    @Override
    public List<EmployeeDto> getEmployeesByRole(Integer roleId) {
        Role role=roleRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("Role","Role Id",roleId));
        List<Employee> employeeList=employeeRepository.findByRole(role);
        return employeeList.stream().map((employee)->modelMapper.map(employee,EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto saveSuperAdmin(EmployeeDto employeeDto) {
        if(employeeDto.getAdminCode()==null || employeeDto.getAdminCode().equals("")) throw new AdminCodeMismatchException("Admin Code Required ... !");
        if(!employeeDto.getAdminCode().equals(ADMIN_CODE)) throw new AdminCodeMismatchException("Please Enter Valid Code ... !");

        Employee employee=modelMapper.map(employeeDto,Employee.class);
        employee.setEmail(employeeDto.getEmail().toLowerCase());
        employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        Role role=new Role();
        role.setId(ADMIN);
        role.setName("ROLE_ADMIN");
        roleRepository.save(role);
        employee.setRole(role);
        return modelMapper.map(employeeRepository.save(employee),EmployeeDto.class);
    }
}
