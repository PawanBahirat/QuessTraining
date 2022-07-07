package com.ems.EmployeeManagementSystem.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="organization")
@NoArgsConstructor
@Getter
@Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer organizationId;
    private String organizationName;
    private String organizationDiscription;
    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "organization",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Asset> assets = new ArrayList<>();
}
