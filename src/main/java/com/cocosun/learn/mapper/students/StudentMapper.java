package com.cocosun.learn.mapper.students;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cocosun.learn.model.students.Student;

@Mapper
public interface StudentMapper {

    // List<Student> findAllStudents();
    List<Student> findAllStudents();
}
