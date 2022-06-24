package com.IPCFeignClient01.App1;


import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Headers("Content-Type:application/json")
@FeignClient(name="${feign.name}",url="${feign.url}")
public interface ClientService {
    @RequestMapping(value = "/app2/employee/save",method = RequestMethod.POST)
    Employee save(Employee employee);
}
