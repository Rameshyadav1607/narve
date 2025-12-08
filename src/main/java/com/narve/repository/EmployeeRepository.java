package com.narve.repository;

import com.narve.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeIdOrEmailId(Integer employeeId, String emailId);

    Employee findByEmployeeId(Integer employeeid);

    @Query("SELECT e FROM Employee e " +
            "JOIN FETCH e.department d " +
            "LEFT JOIN FETCH e.addresses a")
    List<Employee> getEmployeeAllFullData();
}