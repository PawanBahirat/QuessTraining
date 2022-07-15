package com.ems.EmployeeManagementSystem.Controllers;

import com.ems.EmployeeManagementSystem.Entities.Employee;
import com.ems.EmployeeManagementSystem.Payload.ApiResponse;
import com.ems.EmployeeManagementSystem.Payload.OrganizationDto;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepository;
import com.ems.EmployeeManagementSystem.Services.OrganizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationServices organizationServices;
    @Autowired
    private OrganizationRepository organizationRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> saveOrganization(@Valid @RequestBody OrganizationDto organizationDto) {
        if (organizationRepository.findAll().isEmpty()) return new ResponseEntity<>(organizationServices.saveOrganization(organizationDto, getLoginUser().getId()), HttpStatus.CREATED);
        else return new ResponseEntity<>(new ApiResponse("Can't create organization, already one organization is present."),HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable Integer id) { return new ResponseEntity<>(organizationServices.getOrganizationById(id),HttpStatus.OK); }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDto> updateOrganization(@Valid @RequestBody OrganizationDto organizationDto, @PathVariable Integer id) {
        return new ResponseEntity<>(organizationServices.updateOrganization(id,organizationDto),HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteOrganization(@PathVariable Integer id) {
//        organizationServices.deleteOrganization(id);
//        return new ResponseEntity<>(new ApiResponse("Organization deleted successfully"),HttpStatus.OK);
//    }

    public Employee getLoginUser() { return (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); }
}
