package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.CourseRecord;
import java.util.Optional;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface CourseRecordRepository extends CouchbaseRepository<CourseRecord, String> {

    Optional<CourseRecord> findById(String id);
}
