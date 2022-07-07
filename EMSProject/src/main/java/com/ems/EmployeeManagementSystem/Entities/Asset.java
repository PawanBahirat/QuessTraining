package com.ems.EmployeeManagementSystem.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="assets")
@NoArgsConstructor
@Getter
@Setter
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetId;
    private String inventory;
    private String vehicles;
    private String furniture;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
