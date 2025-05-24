package com.cocosun.learn.controller.api.students;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocosun.learn.exception.ResourceNotFoundException;
import com.cocosun.learn.mapper.students.StudentMapper;
import com.cocosun.learn.model.students.Student;
import com.cocosun.learn.repository.students.StudentRepository;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor

public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Operation(summary = "Create a student")
    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student); // JPA, Spring Data JPA for CRUD-heavy modules (like User, Product, etc.)
    }

    @Operation(summary = "Get a student by id")
    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        Student stu = studentRepository.findById(id).orElse(null); // JPA
        if (stu == null) {
            throw new ResourceNotFoundException("Student not found");
        }
        return stu;
    }

    @Operation(summary = "List all students")
    @GetMapping
    public List<Student> findAll() {
        return studentMapper.findAllStudents(); // MyBatis, MyBatis for reporting, search, analytics, batch queries
    }
}
