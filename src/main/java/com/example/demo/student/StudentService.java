package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static java.time.Month.OCTOBER;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> getStudents(){
        return (List<Student>)studentRepository.findAll();
    }

    public void addNewStudent(Student student){
       Optional<Student> StudentByEmail= studentRepository.findStudentByEmail(student.getEmail());
       if (StudentByEmail.isPresent()){
           throw new IllegalStateException("email taken");
       }
        studentRepository.save(student);
    }
    public void deleteStudent(Long studentId){
        boolean exists =studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student with "+studentId+" doesn't exists");
        }
        studentRepository.deleteById(studentId);
    }

}
