package com.langworthy.couchbasedemo.controller;

import com.langworthy.couchbasedemo.model.Student;
import com.langworthy.couchbasedemo.service.StudentService;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Flux<Student> listAllStudents() {
        return studentService.fetchAllStudents();
    }
}
