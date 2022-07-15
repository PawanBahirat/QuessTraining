package com.ems.EmployeeManagementSystem.Repositories;
import com.ems.EmployeeManagementSystem.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> { }
