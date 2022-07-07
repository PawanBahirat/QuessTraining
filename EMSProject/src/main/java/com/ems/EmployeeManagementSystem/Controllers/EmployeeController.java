package com.ems.EmployeeManagementSystem.Controllers;

import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Entities.Role;
import com.ems.EmployeeManagementSystem.Payloads.ApiResponse;
import com.ems.EmployeeManagementSystem.Payloads.EmployeeDto;
import com.ems.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/organization/{orgId}/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@Valid  @RequestBody EmployeeDto employeeDto, @PathVariable Integer orgId){
        return new ResponseEntity<EmployeeDto>(this.employeeService.createEmployee(employeeDto,orgId), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<List<EmployeeDto>>(this.employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee principal1 = (Employee) principal;
        if(principal1.getEmployeeId() == employeeId)
            return new ResponseEntity<EmployeeDto>(this.employeeService.getEmployeeById(employeeId), HttpStatus.OK);
        else return new ResponseEntity<>("Unuthorized !!!",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/employees/{employeeId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse deleteEmployee(@PathVariable Integer employeeId){
        this.employeeService.deleteEmployee(employeeId);
        return new ApiResponse("Employee Deleted Successfully !!",true);
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer employeeId){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employee principal1 = (Employee) principal;
        if(principal1.getEmployeeId() == employeeId) return new ResponseEntity<EmployeeDto>(this.employeeService.updateEmployee(employeeDto,employeeId),HttpStatus.OK);
        else return new ResponseEntity<>("Unuthorized !!!",HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/admin/set-role/{id}")
    public void adminSetRole(@PathVariable("id") Integer id , @RequestBody Role role) {
        employeeService.adminSetRole(id, role);
    }
}
