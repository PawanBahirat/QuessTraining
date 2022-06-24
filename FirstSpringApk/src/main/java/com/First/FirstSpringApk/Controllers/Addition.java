package com.First.FirstSpringApk.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addition {
    @GetMapping("/Addition")
    public int hello(){
        return (30+20);
    }
}