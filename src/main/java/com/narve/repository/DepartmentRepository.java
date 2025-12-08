package com.narve.repository;

import com.narve.model.Department;
import jakarta.validation.constraints.Negative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDepartmentName(String departmentName);


    @Query("select d.departmentName from Department d")
    List<String> getAllDepartmentNames();
}