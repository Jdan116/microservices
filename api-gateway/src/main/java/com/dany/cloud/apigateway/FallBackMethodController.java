package com.dany.cloud.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userFallBack")
    public String userServiceFallBack() {
        return "User Service is taking longer then Excepted. Please try again later.";
    }

    @GetMapping("/departmentFallBack")
    public String departmentServiceFallBack() {
        return "Department Service is taking longer then Excepted. Please try again later.";
    }
}
