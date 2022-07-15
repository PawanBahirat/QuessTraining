package com.ems.EmployeeManagementSystem.Controllers;

import com.ems.EmployeeManagementSystem.Payload.ApiResponse;
import com.ems.EmployeeManagementSystem.Payload.AssetDto;
import com.ems.EmployeeManagementSystem.Services.AssetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/assets")
@RestController
public class AssetController {

    @Autowired
    private AssetServices assetServices;

    @PostMapping("/organization/{organizationId}")
    public ResponseEntity<AssetDto> saveAsset(@Valid @RequestBody AssetDto assetDto, @PathVariable Integer organizationId) {
        return new ResponseEntity<>(assetServices.saveAsset(assetDto,organizationId), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetDto> getAssetById(@PathVariable Integer id) { return new ResponseEntity<>(assetServices.getAssetById(id),HttpStatus.OK); }

    @GetMapping("/")
    public ResponseEntity<List<AssetDto>> getAllAssets() { return new ResponseEntity<>(assetServices.getAllAssets(),HttpStatus.OK); }

    @PutMapping("/{id}")
    public ResponseEntity<AssetDto> updateAsset(@PathVariable Integer id,@Valid @RequestBody AssetDto assetDto) { return new ResponseEntity<>(assetServices.updateAsset(id,assetDto),HttpStatus.OK); }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteAsset(@PathVariable Integer id) {
        assetServices.deleteAsset(id);
        return new ResponseEntity<>(new ApiResponse("Asset deleted successfully"),HttpStatus.OK);
    }
}
