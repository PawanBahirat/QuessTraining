package com.ems.EmployeeManagementSystem.Services.ServicesImpl;
import com.ems.EmployeeManagementSystem.Entities.Asset;
import com.ems.EmployeeManagementSystem.Entities.Organization;
import com.ems.EmployeeManagementSystem.Exceptions.ResourceNotFoundException;
import com.ems.EmployeeManagementSystem.Payload.AssetDto;
import com.ems.EmployeeManagementSystem.Repositories.AssetRepository;
import com.ems.EmployeeManagementSystem.Repositories.OrganizationRepository;
import com.ems.EmployeeManagementSystem.Services.AssetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServicesImpl implements AssetServices {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AssetDto saveAsset(AssetDto assetDto, Integer organizationId) {
        Organization organization =organizationRepository.findById(organizationId).orElseThrow(()->new ResourceNotFoundException("Organization","Organization Id",organizationId));
        Asset asset=modelMapper.map(assetDto,Asset.class);
        asset.setOrganization(organization);
        return modelMapper.map(assetRepository.save(asset),AssetDto.class);
    }

    @Override
    public AssetDto getAssetById(Integer id) {
        Asset asset=assetRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Asset","Asset Id",id));
        return modelMapper.map(asset,AssetDto.class);
    }

    @Override
    public List<AssetDto> getAllAssets() {
        List<Asset> assets=assetRepository.findAll();
        List<AssetDto> assetDtos=assets.stream().map(asset->modelMapper.map(asset,AssetDto.class)).collect(Collectors.toList());
        return assetDtos;
    }

    @Override
    public AssetDto updateAsset(Integer id, AssetDto assetDto) {
        Asset asset=assetRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Asset","Asset Id",id));
        asset.setName(assetDto.getName());
        asset.setIssuedOn(assetDto.getIssuedOn());
        asset.setExpireOn(assetDto.getExpireOn());
        return modelMapper.map(assetRepository.save(asset),AssetDto.class);
    }

    @Override
    public void deleteAsset(Integer id) {
        Asset asset=assetRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Asset","Asset Id",id));
        assetRepository.delete(asset);
    }
}
