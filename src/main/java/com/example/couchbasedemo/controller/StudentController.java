package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.dto.StudentRecordDto;
import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<StudentRecord> listAllStudents() {
        return studentService.fetchAllStudents();
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentRecordDto studentRecord) {
        log.info("Student Record: {}", studentRecord.toString());

//        Map<String, EnrollmentDto> enrollmentDtoMap = studentRecord.getEnrollments();
//        enrollmentDtoMap.forEach((id, enrollment) -> log.info("Id: {} -> Enrollment: {}", id, enrollment));

        StudentRecord newStudentRecord = new StudentRecord(
                studentRecord.getId(), studentRecord.getName(), studentRecord.getDateOfBirth(), new ArrayList<>());

        studentService.create(newStudentRecord);
    }
}
