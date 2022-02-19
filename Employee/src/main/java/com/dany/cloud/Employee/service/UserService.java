package com.dany.cloud.Employee.service;

import com.dany.cloud.Employee.domain.Department;
import com.dany.cloud.Employee.domain.Employee;
import com.dany.cloud.Employee.domain.User;
import com.dany.cloud.Employee.repository.EmployeeRepository;
import com.dany.cloud.Employee.service.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<User> getUserInfo(Long id) {

        Employee employee = employeeRepository.findById(id).get();
        Department department = getEmployeeDepartment(id);
        User user = new User();
        user.setEmployee(employee);
        user.setDepartment(department);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private Department getEmployeeDepartment(Long id) {
        Department department = restTemplate.getForObject(Constants.SERVER_URL + "/" + id, Department.class, " from Spring");
        return department;
    }
}
