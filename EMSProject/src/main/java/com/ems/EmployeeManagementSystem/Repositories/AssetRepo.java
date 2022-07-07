package com.ems.EmployeeManagementSystem.Repositories;

import com.ems.EmployeeManagementSystem.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepo extends JpaRepository<Asset, Integer> {
}
