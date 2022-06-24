
package com.First.FirstSpringApk.Controllers;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String hello(){
        return "******** Success is the maximum utilization of the ability that you have ********".toUpperCase();
    }
}
