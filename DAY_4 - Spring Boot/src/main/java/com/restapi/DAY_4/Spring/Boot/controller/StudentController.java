package com.restapi.DAY_4.Spring.Boot.controller;

import com.restapi.DAY_4.Spring.Boot.model.Student;
import com.restapi.DAY_4.Spring.Boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/all-students")
    private List<Student> getAllStudents()
    {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") Integer id)
    {
        return this.studentService.getStudentById(id);
    }

    @PostMapping("/create-student")
    private String createStudent(@RequestBody Student student)
    {
        return this.studentService.createStudent(student);
    }

    @PutMapping("/update-student")
    private String updateStudent(@RequestBody Student student)
    {
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/delete-student/{id}")
    private String deleteStudent(@PathVariable("id") Integer id)
    {
        return this.studentService.deleteById(id);
    }
}
