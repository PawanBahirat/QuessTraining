package com.crud.CrudOperations.Repository;

import com.crud.CrudOperations.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
