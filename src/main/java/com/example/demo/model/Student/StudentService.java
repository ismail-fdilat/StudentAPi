package com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public final StudentRepository SRepository ;
    public StudentService(StudentRepository SRepository){
        this.SRepository = SRepository;
    }

    public List<Student> getStudents(){
        return SRepository.findAll();
    }
    public void registerStudent(Student s) {
        Optional<Student> studentByEmail = SRepository.findStudentByEmail(s.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email is already taken");
        }
        SRepository.save(s);
    }

    public void deleteStudent(Long id) {
        Boolean exists =SRepository.existsById(id);
        if (!exists){
               throw new IllegalStateException("the student id : "+id+"  deos not exists");
                    }
        SRepository.deleteById(id);
        }
}
