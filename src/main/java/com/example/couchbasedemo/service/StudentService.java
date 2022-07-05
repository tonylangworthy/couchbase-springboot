package com.example.couchbasedemo.service;

import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.repository.StudentRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("StudentService")
public class StudentService {

    private final StudentRecordRepository studentRecordRepository;

    public StudentRecord create(StudentRecord studentRecord) {
        return studentRecordRepository.save(studentRecord);
    }

    public List<StudentRecord> fetchAllStudents() {
        return studentRecordRepository.findAll();
    }
}
