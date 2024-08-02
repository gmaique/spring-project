package com.gin.controller;

import com.gin.entity.Student;
import com.gin.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class studentController {

    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
        this.studentService.initializeDatabase();
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}



//
//testes com regra de negocio
//teste unitario
//teste integracao