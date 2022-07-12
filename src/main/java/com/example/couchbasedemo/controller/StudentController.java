package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.dto.EnrollmentDto;
import com.example.couchbasedemo.dto.StudentRecordDto;
import com.example.couchbasedemo.exception.StudentNotFoundException;
import com.example.couchbasedemo.model.Enrollment;
import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.service.CourseService;
import com.example.couchbasedemo.service.StudentService;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentRecordDto> listAllStudents() {
        return studentService.fetchAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentRecordDto> getStudentById(@PathVariable String id) {
        log.info("Fetching student with id: {}", id);

        StudentRecordDto studentRecordDto;

        try {
             studentRecordDto = studentService.findByStudentId(id);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentRecordDto);
   }

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentRecordDto studentRecordDto) {
        log.info("Student Record: {}", studentRecordDto.toString());

        studentService.create(studentRecordDto);
    }

    @PutMapping("/students")
    public void updateStudent(@RequestBody StudentRecordDto studentRecordDto) {
        log.info("Updating Student Record: {}", studentRecordDto);

        studentService.update(studentRecordDto);
    }
}
