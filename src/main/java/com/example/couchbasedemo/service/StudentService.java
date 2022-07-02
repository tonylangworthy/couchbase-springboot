package com.example.couchbasedemo.service;

import com.example.couchbasedemo.model.StudentRecord;
import com.example.couchbasedemo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<StudentRecord> create(StudentRecord studentRecord) {
        return Mono.just(studentRepository.save(studentRecord));
    }

    public Flux<StudentRecord> fetchAllStudents() {
        return studentRepository.findAll();
    }
}
