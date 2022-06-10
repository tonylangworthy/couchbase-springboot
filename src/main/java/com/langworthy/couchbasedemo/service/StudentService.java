package com.langworthy.couchbasedemo.service;

import com.langworthy.couchbasedemo.model.Student;
import com.langworthy.couchbasedemo.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<Student> create(Student student) {
        return studentRepository.save(student);
    }

    public Flux<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }
}
