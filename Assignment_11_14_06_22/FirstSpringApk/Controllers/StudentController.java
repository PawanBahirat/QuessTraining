package com.First.FirstSpringApk.Controllers;

import com.First.FirstSpringApk.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class StudentController {
//    @GetMapping("/Student")
//    public ArrayList<Student> studentDetails(){
//        return new ArrayList<>(Arrays.asList(new Student[]{new Student("Kasure","Sanay"),new Student("Matsagar","Sagar"),new Student("Dalvi","Sagar"),new Student("Rahane","Amit"),new Student("Joshi","Atharva")}));
//    }
//    @GetMapping("/Student/{firstName}/{lastName}")
//    public Student StudentDetails(@PathVariable("FirstName") String FirstName,@PathVariable("LastName") String LastName){
//        return new Student(FirstName,LastName);
//    }
    @GetMapping("/Student")
    public String StudentDetails(@RequestParam(name="FirstName") String firstName,@RequestParam(name="LastName") String lastName){
        return firstName+" "+lastName;
    }

}
