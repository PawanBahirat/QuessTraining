package com.ems.EmployeeManagementSystem.Controllers;

import com.ems.EmployeeManagementSystem.Payloads.OrganizationDto;
import com.ems.EmployeeManagementSystem.Services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrganizationDto> createCategory(@Valid @RequestBody OrganizationDto organizationDto) {
        return  new ResponseEntity<OrganizationDto>(this.organizationService.createOrganization(organizationDto), HttpStatus.CREATED);
    }

    @PutMapping("/{orgId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrganizationDto> updateOrganization(@Valid @RequestBody OrganizationDto organizationDto, @PathVariable Integer orgId) {
        return  new ResponseEntity<OrganizationDto>(this.organizationService.updateOrganization(organizationDto,orgId), HttpStatus.OK);
    }

    @GetMapping("/{orgId}")
    public ResponseEntity<OrganizationDto> getCategory(@PathVariable Integer orgId) {
        return new ResponseEntity<>(this.organizationService.getOrganization(orgId),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<OrganizationDto>> getAllOrganization() {
        return ResponseEntity.ok(this.organizationService.getAllOrganization());
    }
}