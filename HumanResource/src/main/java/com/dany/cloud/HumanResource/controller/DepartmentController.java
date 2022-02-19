package com.dany.cloud.HumanResource.controller;

import com.dany.cloud.HumanResource.domain.Department;
import com.dany.cloud.HumanResource.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/hr")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment() {
        return departmentService.getAllDepartment();
    }
}
