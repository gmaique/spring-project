package com.gin.service;

import com.gin.entity.Student;
import com.gin.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john.doe@example.com");

        studentService.saveStudent(student);

    }

    @Test
    void testGetAllStudents() {
        Student student = new Student();
        student.setName("John Doe");
        student.setEmail("john.doe@example.com");

        when(studentRepository.getAllStudents()).thenReturn(List.of(student));

        List<Student> students = studentService.getAllStudents();

        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setId(1L);
        student.setName("John Doe");
        student.setEmail("john.doe@example.com");

        when(studentRepository.getStudentById(1L)).thenReturn(student);

        Student foundStudent = studentService.getStudentById(1L);

        assertEquals("John Doe", foundStudent.getName());
    }
}

