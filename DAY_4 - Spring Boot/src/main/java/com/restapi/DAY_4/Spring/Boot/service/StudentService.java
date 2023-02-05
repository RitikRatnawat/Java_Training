package com.restapi.DAY_4.Spring.Boot.service;

import com.restapi.DAY_4.Spring.Boot.model.Student;
import com.restapi.DAY_4.Spring.Boot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    @Autowired
    private StudentRepo studentRepo;

    public String createStudent(Student student)
    {
        if(this.studentRepo.existsById(student.getId()))
            return "Student already exists";
        else
        {
            this.studentRepo.save(student);
            return "Student details are saved";
        }
    }

    public List<Student> getAllStudents()
    {
        return this.studentRepo.findAll();
    }

    public Student getStudentById(Integer id)
    {
        return this.studentRepo.findById(id).get();
    }

    public String updateStudent(Student student)
    {
        Optional<Student> s = this.studentRepo.findById(student.getId());
//
        if(s.isPresent())
        {
            Student s1 = s.get();
            s1.setName(student.getName());
            s1.setCity(student.getCity());
            s1.setContact(student.getContact());

            this.studentRepo.save(s1);
            return "Student details updated";
        }

        return "Student not found";
    }

    public String deleteById(Integer id)
    {
        this.studentRepo.deleteById(id);
        return "Student deleted successfully";
    }
}
