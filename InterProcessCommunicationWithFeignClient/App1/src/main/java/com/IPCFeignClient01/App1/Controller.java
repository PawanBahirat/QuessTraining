package com.IPCFeignClient01.App1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app1")
@RestController
public class Controller {
    @Autowired
    ClientService restClientService;
    @GetMapping("/employee/send")
    public Employee Save() {
        Employee employee = new Employee();
        employee.setFirstName("Sanay");
        employee.setLastName("Kasure");
        return restClientService.save(employee);
    }
}
