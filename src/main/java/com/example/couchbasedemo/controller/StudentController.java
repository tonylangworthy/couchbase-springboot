package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.service.StudentService;
import com.example.couchbasedemo.model.StudentRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public Flux<StudentRecord> listAllStudents() {
        return studentService.fetchAllStudents();
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentRecord studentRecord) {
        System.out.println(studentRecord.toString());
        studentService.create(studentRecord);
    }
}
