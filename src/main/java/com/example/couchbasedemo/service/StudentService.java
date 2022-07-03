package com.example.couchbasedemo.service;

import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.repository.StudentRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRecordRepository studentRecordRepository;

    public StudentService(StudentRecordRepository studentRecordRepository) {
        this.studentRecordRepository = studentRecordRepository;
    }

    public StudentRecord create(StudentRecord studentRecord) {
        return studentRecordRepository.save(studentRecord);
    }

    public List<StudentRecord> fetchAllStudents() {
        return studentRecordRepository.findAll();
    }
}
