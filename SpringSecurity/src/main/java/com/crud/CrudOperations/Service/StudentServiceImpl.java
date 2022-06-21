package com.crud.CrudOperations.Service;

import com.crud.CrudOperations.Exceptions.StudentNotFoundException;
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
    public Student getStudentById(int id){ return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));}
    @Override
    public Student updateStudent(Student student, int id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        studentRepository.save(existingStudent);
        return existingStudent;
    }
    @Override
    public void deleteStudent(int id){
        studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException(id));
        studentRepository.deleteById(id);
    }

}
