package com.ems.EmployeeManagementSystem.Controllers;


import com.ems.EmployeeManagementSystem.Payloads.ApiResponse;
import com.ems.EmployeeManagementSystem.Payloads.AssetDto;
import com.ems.EmployeeManagementSystem.Payloads.EmployeeDto;
import com.ems.EmployeeManagementSystem.Services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssetController {
    @Autowired
    AssetService assetService;

    @PostMapping("/organization/{orgId}/assets")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AssetDto> createAsset(@RequestBody AssetDto assetDto, @PathVariable Integer orgId){
        return new ResponseEntity<AssetDto>(this.assetService.createAsset(assetDto,orgId), HttpStatus.CREATED);
    }

    @GetMapping("/assets")
    public ResponseEntity<List<AssetDto>> getAllAsset(){
        return new ResponseEntity<List<AssetDto>>(this.assetService.getAllAsset(),HttpStatus.OK);
    }

    @GetMapping("/assets/{assetId}")
    public ResponseEntity<AssetDto> getAssetById(@PathVariable Integer assetId){
        return new ResponseEntity<AssetDto>(this.assetService.getAssetById(assetId), HttpStatus.OK);
    }

    @DeleteMapping("/assets/{assetId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse deleteAsset(@PathVariable Integer assetId){
        this.assetService.deleteAsset(assetId);
        return new ApiResponse("Asset Deleted Successfully !!",true);
    }

    @PutMapping("/assets/{assetId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AssetDto> updateAsset(@RequestBody AssetDto assetDto, @PathVariable Integer assetId){
        return new ResponseEntity<AssetDto>(this.assetService.updateAsset(assetDto,assetId),HttpStatus.OK);
    }
}