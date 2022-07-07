package com.ems.EmployeeManagementSystem.Repositories;

import com.ems.EmployeeManagementSystem.Entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization, Integer> {

}
