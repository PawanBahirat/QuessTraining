package com.example.demo;

import com.example.demo.Bean.Addition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
    @Autowired
    private Addition addition;
    @GetMapping("/addition")
    public String displayAddition() {
        return ("First Num : "+addition.getNum1() +" Second Num : "+addition.getNum2()+" Addition = "+(addition.getNum1()+addition.getNum2()));
    }
}
