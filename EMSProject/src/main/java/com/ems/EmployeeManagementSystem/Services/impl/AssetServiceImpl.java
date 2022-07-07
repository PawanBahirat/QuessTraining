package com.ems.EmployeeManagementSystem.Services.impl;

import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payloads.AssetDto;
import com.ems.EmployeeManagementSystem.Repositories.AssetRepo;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepo;
import com.ems.EmployeeManagementSystem.Services.AssetService;
import com.ems.EmployeeManagementSystem.Entities.Asset;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AssetServiceImpl  implements AssetService {
    @Autowired
    private OrganizationRepo organizationRepo;
    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AssetDto createAsset(AssetDto assetDto, Integer orgId) {
        Organization organization = this.organizationRepo.findById(orgId).orElseThrow(()-> new ResourceNotFoundException("Organization","Organization Id ",orgId));
        Asset asset = this.modelMapper.map(assetDto, Asset.class);
        asset.setInventory(asset.getInventory());
        asset.setVehicles(asset.getVehicles());
        asset.setFurniture(asset.getFurniture());
        asset.setOrganization(organization);
        return this.modelMapper.map(this.assetRepo.save(asset), AssetDto.class);
    }

    @Override
    public List<AssetDto> getAllAsset() {
        return this.assetRepo.findAll().stream().map((asset) -> this.modelMapper.map(asset,AssetDto.class)).collect(Collectors.toList());
    }

    @Override
    public AssetDto getAssetById(Integer assetId) {
        return this.modelMapper.map(this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","Id",assetId)),AssetDto.class);    }

    @Override
    public void deleteAsset(Integer assetId) {
        this.assetRepo.delete(this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","Id", assetId)));
    }

    @Override
    public AssetDto updateAsset(AssetDto assetDto, Integer assetId) {
        Asset asset = this.assetRepo.findById(assetId).orElseThrow(()->new ResourceNotFoundException("Asset","Id", assetId));
        asset.setInventory(assetDto.getInventory());
        asset.setVehicles(assetDto.getVehicles());
        asset.setFurniture(assetDto.getFurniture());
        Asset updatedAsset = this.assetRepo.save(asset);
        return this.modelMapper.map(updatedAsset,AssetDto.class);    }
}
