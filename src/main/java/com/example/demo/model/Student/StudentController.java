package com.example.demo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Student")
public class StudentController {
    private final  StudentService studentService ;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> GetStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void RegisterStudent(@RequestBody Student s){
    studentService.registerStudent(s);
    }
    @DeleteMapping(path=("{studentId}"))
    public void deleteStudent(@PathVariable("studentId") Long Id){
    studentService.deleteStudent(Id);
    }

}
