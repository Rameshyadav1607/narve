package com.narve.resource;

import com.narve.domain.DepartmentDomain;
import com.narve.domain.DepartmentResponse;
import com.narve.model.Department;
import com.narve.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentResource {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    public String createOrUpdateDepartment(@RequestBody DepartmentDomain departmentDomain){
        return  departmentService.createOrUpdateDepartmemt(departmentDomain);

    }

    @GetMapping("/names")
    public List<String> departementNames(){
        return departmentService.deptmentNames();
    }
    @GetMapping("/all")
    public List<DepartmentResponse> getAllDepartments(){
        return  departmentService.getAllDepartments();
    }


    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable Integer departmentId){
        departmentService.deleteDepartment(departmentId);
    }

}
