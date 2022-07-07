package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.dto.EnrollmentDto;
import com.example.couchbasedemo.dto.StudentRecordDto;
import com.example.couchbasedemo.exception.StudentNotFoundException;
import com.example.couchbasedemo.model.Enrollment;
import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.service.StudentService;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/students/{id}")
    public ResponseEntity getStudentById(@PathVariable String id) {
        log.info("Fetching student with id: {}", id);

        StudentRecord studentRecord;

        try {
             studentRecord = studentService.findByStudentId(id);
        } catch (StudentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        List<EnrollmentDto> enrollmentDtos = studentRecord.getEnrollments().stream().map(enrollment -> {
            return new EnrollmentDto(
                    enrollment.getId(), enrollment.getDateEnrolled(), enrollment.getDateCompleted());
        }).collect(Collectors.toList());

        StudentRecordDto studentRecordDto = new StudentRecordDto(studentRecord.getId(), studentRecord.getName(),
                studentRecord.getDateOfBirth(), enrollmentDtos);
        return ResponseEntity.ok(studentRecordDto);
   }

    @PostMapping("/students")
    public void createStudent(@RequestBody StudentRecordDto studentRecord) {
        log.info("Student Record: {}", studentRecord.toString());

        List<Enrollment> enrollmentList = new ArrayList<>();

        List<EnrollmentDto> enrollmentDtoMap = studentRecord.getEnrollments();
        enrollmentDtoMap.forEach(enrollment -> {
            enrollmentList.add(new Enrollment(
                    enrollment.getCourseId(), enrollment.getDateEnrolled(), enrollment.getDateCompleted()));
        });

        StudentRecord newStudentRecord = new StudentRecord(
                studentRecord.getId(), studentRecord.getName(), studentRecord.getDateOfBirth(), enrollmentList);

        studentService.create(newStudentRecord);
    }
}
