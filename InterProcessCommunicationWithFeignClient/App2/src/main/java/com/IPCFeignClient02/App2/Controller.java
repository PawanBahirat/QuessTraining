package com.IPCFeignClient02.App2;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app2")
@RestController
public class Controller {
    @PostMapping("/employee/save")
    public Employee save(Employee employee) {
        employee.setFirstName("Atharv");
        employee.setLastName("Joshi");
        return employee;
    }
}
