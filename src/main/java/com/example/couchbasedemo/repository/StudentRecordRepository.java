package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.StudentRecord;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRecordRepository extends ReactiveCouchbaseRepository<StudentRecord, String> {

    Flux<StudentRecord> findAll();
}
