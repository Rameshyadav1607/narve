package com.narve.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentDomain {
    private Integer departmentId;
    private String departmentName;
    private String departmentLocation;

    public DepartmentDomain(int departmentId, String departmentName, String departmentLocation) {
        this.departmentId=departmentId;
        this.departmentName=departmentName;
        this.departmentLocation=departmentLocation;
    }
}
