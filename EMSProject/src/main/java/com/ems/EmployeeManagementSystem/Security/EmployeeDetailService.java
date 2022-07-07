package com.ems.EmployeeManagementSystem.Security;

import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = this.employeeRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("Employee","email",username));
        return employee;
    }
}
