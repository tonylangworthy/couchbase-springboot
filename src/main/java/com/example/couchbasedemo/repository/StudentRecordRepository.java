package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.StudentRecord;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface StudentRecordRepository extends CouchbaseRepository<StudentRecord, String> {

    @Override
    List<StudentRecord> findAll(Sort sort);
}
