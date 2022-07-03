package com.example.couchbasedemo.service;

import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.repository.StudentRecordRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRecordRepository studentRecordRepository;

    public StudentService(StudentRecordRepository studentRecordRepository) {
        this.studentRecordRepository = studentRecordRepository;
    }

    public Mono<StudentRecord> create(StudentRecord studentRecord) {
        return studentRecordRepository.save(studentRecord);
    }

    public Flux<StudentRecord> fetchAllStudents() {
        return studentRecordRepository.findAll();
    }
}
