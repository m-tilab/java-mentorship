package com.hafa.OnlineLibrary.feature_crud.service;


import com.hafa.OnlineLibrary.feature_crud.entity.Student;
import com.hafa.OnlineLibrary.feature_crud.exceptions.InvalidParamException;
import com.hafa.OnlineLibrary.feature_crud.exceptions.NotFoundException;
import com.hafa.OnlineLibrary.feature_crud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        if (student.getId() < 1)
            throw new InvalidParamException("Invalid id");

        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) {
            Student savedStudent = optionalStudent.get();
            savedStudent.setFirstName(student.getFirstName());
            savedStudent.setLastName(student.getLastName());
            savedStudent.setEmail(student.getEmail());
            studentRepository.save(savedStudent);
            return student;
        } else
            throw new NotFoundException("Student not found with given id");
    }

    @Override
    public Student findStudentById(long studentId) {
        if (studentId < 1)
            throw new InvalidParamException("Invalid id");

        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else throw new NotFoundException("Student not found with given id");

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteStudentById(long studentId) {
        if (studentId < 1)
            throw new InvalidParamException("Invalid id");

        studentRepository.deleteById(studentId);
    }
}
