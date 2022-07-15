package com.ems.EmployeeManagementSystem.Services;

import com.ems.EmployeeManagementSystem.Payload.AssetDto;
import java.util.List;

public interface AssetServices {
    AssetDto saveAsset(AssetDto assetDto, Integer organizationId);
    AssetDto getAssetById(Integer id);
    List<AssetDto> getAllAssets();
    AssetDto updateAsset(Integer id,AssetDto asset);
    void deleteAsset(Integer id);
}
