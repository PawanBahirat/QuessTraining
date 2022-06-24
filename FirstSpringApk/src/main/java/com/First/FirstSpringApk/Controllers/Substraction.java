package com.First.FirstSpringApk.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Substraction {
    @GetMapping("/Substraction")
    public int hello(){
        return (30-20);
    }
}