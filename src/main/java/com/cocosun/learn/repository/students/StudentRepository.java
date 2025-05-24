package com.cocosun.learn.repository.students;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cocosun.learn.model.students.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
