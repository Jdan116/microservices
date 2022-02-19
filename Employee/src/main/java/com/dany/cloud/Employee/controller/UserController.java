package com.dany.cloud.Employee.controller;

import com.dany.cloud.Employee.domain.User;
import com.dany.cloud.Employee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getEmployee(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

}
