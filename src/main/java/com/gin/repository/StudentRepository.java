package com.gin.repository;

import com.gin.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS student (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255), " +
                "email VARCHAR(255))");
    }

    public void insertStudent(Student student) {
        jdbcTemplate.update("INSERT INTO student (name, email) VALUES (?, ?)",
                student.getName(), student.getEmail());
    }

    public List<Student> getAllStudents() {
        return jdbcTemplate.query("SELECT * FROM student",
                new BeanPropertyRowMapper<>(Student.class));
    }

    public Student getStudentById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id = ?",
                new BeanPropertyRowMapper<>(Student.class), id);
    }
}
