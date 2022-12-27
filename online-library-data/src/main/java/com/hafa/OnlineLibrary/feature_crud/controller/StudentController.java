package com.hafa.OnlineLibrary.feature_crud.controller;


import com.hafa.OnlineLibrary.feature_crud.entity.Student;
import com.hafa.OnlineLibrary.feature_crud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/findById/{studentId}")
    public Student findById(@PathVariable Long studentId) {
        return studentService.findStudentById(studentId);
    }


    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }

}
