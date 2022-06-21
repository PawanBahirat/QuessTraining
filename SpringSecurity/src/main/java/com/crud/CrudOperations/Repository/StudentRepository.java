package com.crud.CrudOperations.Repository;

import com.crud.CrudOperations.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Object> findByEmail(String email);
}
