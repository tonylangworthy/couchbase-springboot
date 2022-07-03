package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.CourseRecord;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface CourseRecordRepository extends CouchbaseRepository<CourseRecord, String> {
}
