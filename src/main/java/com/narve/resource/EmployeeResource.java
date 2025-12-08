package com.narve.resource;

import com.narve.domain.EmployeeDomain;
import com.narve.domain.EmployeeResponse;
import com.narve.repository.EmployeeRepository;
import com.narve.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<String> createOrUpdateEmployee(@RequestBody EmployeeDomain employeeDomain){
        return employeeService.createOrUpdateEmployee(employeeDomain);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @DeleteMapping("/{employeeid}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeid){
         return  employeeService.deleteEmployeeById(employeeid);

    }

}
