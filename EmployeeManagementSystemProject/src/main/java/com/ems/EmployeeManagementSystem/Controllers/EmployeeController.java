package com.ems.EmployeeManagementSystem.Controllers;
import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payload.ApiResponse;
import com.ems.EmployeeManagementSystem.Payload.EmployeeDto;
import com.ems.EmployeeManagementSystem.Payload.RoleDto;
import com.ems.EmployeeManagementSystem.Repositories.EmployeeRepository;
import com.ems.EmployeeManagementSystem.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/organization/{organizationId}")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable Integer organizationId) {
        return new ResponseEntity<>(employeeServices.saveEmployee(employeeDto,organizationId), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Role",id));
        if(getLoginUser().getId()==id) return new ResponseEntity<>(employeeServices.getEmployeeById(id),HttpStatus.OK);
        else if(getLoginUser().getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(employeeServices.getEmployeeById(id),HttpStatus.OK);
        else if(getLoginUser().getRole().getName().equals("ROLE_HR") && !employee.getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(employeeServices.getEmployeeById(id),HttpStatus.OK);
        else return new ResponseEntity<>(new ApiResponse("Unauthorized Access ... !"),HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() { return new ResponseEntity<>(employeeServices.getAllEmployees(),HttpStatus.OK); }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByRole(@PathVariable Integer roleId) { return new ResponseEntity<>(employeeServices.getEmployeesByRole(roleId),HttpStatus.OK); }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer id,@Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        if(employee.getRole().getName().equals("ROLE_ADMIN"))
            if(getLoginUser().getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(employeeServices.updateEmployee(id,employeeDto),HttpStatus.OK);
            else return new ResponseEntity<>(new ApiResponse("Unauthorized Access ... !"),HttpStatus.UNAUTHORIZED);
        if(getLoginUser().getId()==id) return new ResponseEntity<>(employeeServices.updateEmployee(id,employeeDto),HttpStatus.OK);
        else if (getLoginUser().getRole().getName().equals("ROLE_HR")) return new ResponseEntity<>(employeeServices.updateEmployee(id,employeeDto),HttpStatus.OK);
        else if (getLoginUser().getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(employeeServices.updateEmployee(id,employeeDto),HttpStatus.OK);
        else return new ResponseEntity<>(new ApiResponse("Unauthorized Access ... !"),HttpStatus.UNAUTHORIZED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/updateRole")
    public ResponseEntity<ApiResponse> updateEmployeeRole(@PathVariable Integer id,@Valid @RequestBody RoleDto roleDto) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Role",id));
        if(employee.getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(new ApiResponse("Cannot change admin role ... !"),HttpStatus.BAD_REQUEST);

        String roleUpdateMessage=employeeServices.updateEmployeeRole(id,roleDto);
        return new ResponseEntity<>(new ApiResponse(roleUpdateMessage),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Employee Id",id));
        if(employee.getRole().getName().equals("ROLE_ADMIN")) return new ResponseEntity<>(new ApiResponse("Cannot delete admin ... !"),HttpStatus.BAD_REQUEST);
        else {
            employeeServices.deleteEmployee(id);
            return new ResponseEntity<>(new ApiResponse("Employee deleted successfully"),HttpStatus.OK);
        }
    }
    @PostMapping("/admin")
    public ResponseEntity<?> saveSuperAdmin(@Valid @RequestBody EmployeeDto employeeDto) {
        if(employeeRepository.findAll().isEmpty()) return new ResponseEntity<>(employeeServices.saveSuperAdmin(employeeDto),HttpStatus.CREATED);
        else return new ResponseEntity<>(new ApiResponse("Admin is already registered."),HttpStatus.BAD_REQUEST);
    }

    public Employee getLoginUser() {
        Employee employee= (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return employee;
    }
}