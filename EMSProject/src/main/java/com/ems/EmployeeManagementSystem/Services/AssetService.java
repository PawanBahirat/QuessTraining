package com.ems.EmployeeManagementSystem.Services;
import com.ems.EmployeeManagementSystem.Payloads.AssetDto;
import java.util.List;

public interface AssetService {

    AssetDto createAsset(AssetDto assetDto, Integer orgId);

    List<AssetDto> getAllAsset();

    AssetDto getAssetById(Integer assetId);

    void deleteAsset(Integer assetId);

    AssetDto updateAsset(AssetDto assetDto, Integer assetId);
}
