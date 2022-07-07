package com.ems.EmployeeManagementSystem.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AssetDto {
    private Integer assetId;
    private String inventory;
    private String vehicles;
    private String furniture;
}
