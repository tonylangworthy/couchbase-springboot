package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.StudentRecord;
import jakarta.nosql.mapping.Repository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public interface StudentRepository extends Repository<StudentRecord, String> {

    Flux<StudentRecord> findAll();
}
