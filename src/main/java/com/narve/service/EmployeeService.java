package com.narve.service;

import com.narve.domain.AddressDomain;
import com.narve.domain.DepartmentDomain;
import com.narve.domain.EmployeeDomain;
import com.narve.domain.EmployeeResponse;
import com.narve.model.Address;
import com.narve.model.Department;
import com.narve.model.Employee;
import com.narve.repository.DepartmentRepository;
import com.narve.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<String> createOrUpdateEmployee(EmployeeDomain employeeDomain) {

        Employee employee = employeeRepository.findByEmployeeIdOrEmailId(
                employeeDomain.getEmployeeId(),
                employeeDomain.getEmailId()
        );

        Department department = departmentRepository.findByDepartmentName(employeeDomain.getDepartmentName());
        if(department == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("department not found :");
        }
        if(employee == null){
            employee =new Employee();
            employee.setCreatedDate(LocalDate.now());
        } else {
            employee.setUpdatedDate(LocalDate.now());
        }

        employee.setFirstName(employeeDomain.getFirstName());
        employee.setLastName(employeeDomain.getLastName());
        employee.setDepartment(department);
        employee.setEmailId(employeeDomain.getEmailId());
        employee.setPhoneNo(employeeDomain.getPhoneNo());
        employeeRepository.save(employee);
        return  ResponseEntity.ok("Employee Inserted or updated");
    }

    public ResponseEntity<?> deleteEmployeeById(Integer employeeid) {

        Employee employee = employeeRepository.findByEmployeeId(employeeid);
        if(employee == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("employee not found");
        }else{
            employeeRepository.deleteById(employee.getEmployeeId());
            return ResponseEntity.status(HttpStatus.CONFLICT).body("employee deleted");
        }
    }

    public List<EmployeeResponse> getAllEmployees(){
        List<Employee>    employees=employeeRepository.getEmployeeAllFullData();

        List<EmployeeResponse> list = new ArrayList<>();

        for(Employee e :employees){
            DepartmentDomain departmentDomain=new DepartmentDomain(
                    e.getDepartment().getDepartmentId(),
                    e.getDepartment().getDepartmentName(),
                    e.getDepartment().getDepartmentLocation()
            );

          List<AddressDomain>  addresesList=e.getAddresses()
                    .stream().map(a -> new AddressDomain(
                            a.getAddressId(),
                            a.getHouseNo(),
                            a.getStreet(),
                            a.getZipcode(),
                            a.getStateOfCountry(),
                            a.getCountry()

                            )
                    ).collect(Collectors.toList());

            list.add(new EmployeeResponse(
                    e.getEmployeeId(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getEmailId(),
                    e.getPhoneNo(),
                    departmentDomain,
                    addresesList
            ));

        }

        return list;
    }
}
