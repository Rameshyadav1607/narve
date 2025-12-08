package com.narve.service;

import com.narve.domain.DepartmentDomain;
import com.narve.domain.DepartmentResponse;
import com.narve.model.Department;
import com.narve.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public String createOrUpdateDepartmemt(DepartmentDomain departmentDomain) {

        Department department = departmentRepository.findByDepartmentName(departmentDomain.getDepartmentName());
         if(department == null){
             department=new Department();
             department.setDepartmentName(departmentDomain.getDepartmentName());
             department.setDepartmentLocation(department.getDepartmentLocation());
             department.setCreatedDate(LocalDate.now());
         }
         else{
             department.setDepartmentId(department.getDepartmentId());
             department.setDepartmentName(departmentDomain.getDepartmentName());
             department.setDepartmentLocation(departmentDomain.getDepartmentLocation());
             department.setUpdatedDate(LocalDate.now());
         }

        departmentRepository.save(department);

        return  "department created/updated";

    }


    public List<String> deptmentNames() {
         List<String>     names=departmentRepository.getAllDepartmentNames();
         return names;
    }

    public void deleteDepartment(Integer departmentId) {
        boolean exists = departmentRepository.existsById(departmentId);
        if (!exists) {
            System.out.println("Department not found with id: " + departmentId);
            return;
        }
        departmentRepository.deleteById(departmentId);

    }

    public List<DepartmentResponse> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

      return   departments.stream().map( dept -> {

          DepartmentResponse response=new DepartmentResponse();
          response.setDepartmentId(dept.getDepartmentId());
          response.setDepartmentName(dept.getDepartmentName());
          response.setDepartmentLocation(dept.getDepartmentLocation());
          response.setCreatedDate( dept.getCreatedDate()!=null ? dept.getCreatedDate(): null);
          response.setUpdatedDate(dept.getUpdatedDate()!=null? dept.getUpdatedDate() : null);
          return response;

      }).collect(Collectors.toList());


    }
}
