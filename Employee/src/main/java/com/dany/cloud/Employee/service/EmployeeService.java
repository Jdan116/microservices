package com.dany.cloud.Employee.service;

import com.dany.cloud.Employee.domain.Employee;
import com.dany.cloud.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {
        if (employeeRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Employee> getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
    }


}
