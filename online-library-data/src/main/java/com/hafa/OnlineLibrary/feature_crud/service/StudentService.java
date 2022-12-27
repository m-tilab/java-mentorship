package com.hafa.OnlineLibrary.feature_crud.service;

import com.hafa.OnlineLibrary.feature_crud.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student updateStudent(Student student);

    Student findStudentById(long studentId);

    List<Student> findAll();

    void deleteStudentById(long studentId);

}
