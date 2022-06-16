package com.crud.CrudOperations.Service;

import com.crud.CrudOperations.Models.Student;
import com.crud.CrudOperations.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public Student saveStudent(Student student) {return studentRepository.save(student);}
    @Override
    public List<Student> getAllStudents(){return studentRepository.findAll();}
    @Override
    public Student getStudentById(int id){ return studentRepository.findById(id).orElseThrow();}
    @Override
    public Student updateStudent(Student student, int id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow();

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setLastName(student.getClassName());
        existingStudent.setLastName(student.getAge());
        existingStudent.setLastName(student.getGender());
        existingStudent.setEmail(student.getEmail());



        //save existing student to the database.
        studentRepository.save(existingStudent);
        return existingStudent;
    }
    @Override
    public void deleteStudent(int id){
        studentRepository.findById(id).orElseThrow();
        studentRepository.deleteById(id);
    }

}
