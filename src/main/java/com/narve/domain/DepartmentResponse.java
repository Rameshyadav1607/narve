package com.narve.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class DepartmentResponse {

    private Integer departmentId;
    private String departmentName;
    private String departmentLocation;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
