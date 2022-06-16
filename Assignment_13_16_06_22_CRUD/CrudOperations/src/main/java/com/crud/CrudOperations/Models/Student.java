package com.crud.CrudOperations.Models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String className;
    @Column(nullable = false)
    private String age;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String email;
}
