package com.dany.cloud.HumanResource.service;

import com.dany.cloud.HumanResource.domain.Department;
import com.dany.cloud.HumanResource.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public ResponseEntity<Department> addDepartment(Department department) {
        return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    public ResponseEntity<Department> updateDepartment(Long id, Department department) {
        if (departmentRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Department> getDepartment(Long id) {
        return new ResponseEntity<>(departmentRepository.findById(id).get(), HttpStatus.OK);
    }

    public ResponseEntity<List<Department>> getAllDepartment() {
        return new ResponseEntity<>(departmentRepository.findAll(), HttpStatus.OK);
    }
}
