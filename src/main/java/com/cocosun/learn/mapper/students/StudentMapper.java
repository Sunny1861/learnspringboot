package com.cocosun.learn.mapper.students;

import java.util.List;

import com.cocosun.learn.model.students.Student;

public interface StudentMapper {

    List<Student> findAllStudents();
}
