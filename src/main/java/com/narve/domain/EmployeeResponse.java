package com.narve.domain;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class EmployeeResponse {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phoneNo;

    private DepartmentDomain department;

    private List<AddressDomain> address;

    public EmployeeResponse(int employeeId, String firstName, String lastName, String emailId, String phoneNo, DepartmentDomain departmentDomain, List<AddressDomain> addresesList) {
        this.employeeId=employeeId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.emailId=emailId;
        this.phoneNo=phoneNo;
        this.department=departmentDomain;
        this.address=addresesList;
    }
}
