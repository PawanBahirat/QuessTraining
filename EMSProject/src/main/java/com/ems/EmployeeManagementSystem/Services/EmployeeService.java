package com.ems.EmployeeManagementSystem.Services;
import com.ems.EmployeeManagementSystem.Entities.Role;
import com.ems.EmployeeManagementSystem.Payloads.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto, Integer orgId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(Integer employeeId);

    void deleteEmployee(Integer employeeId);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId);

    void adminSetRole(Integer id, Role role);
}
