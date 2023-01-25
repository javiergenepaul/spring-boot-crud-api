package com.crudpractice.crud.controller;

import com.crudpractice.crud.model.Course;
import com.crudpractice.crud.model.Student;
import com.crudpractice.crud.repository.CourseRepository;
import com.crudpractice.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/course")
public class StudentCourseController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCount(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/courses-list")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
