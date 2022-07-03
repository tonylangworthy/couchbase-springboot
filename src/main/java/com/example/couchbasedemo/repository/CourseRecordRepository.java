package com.example.couchbasedemo.repository;

import com.example.couchbasedemo.model.CourseRecord;
import org.springframework.data.repository.CrudRepository;

public interface CourseRecordRepository extends CrudRepository<CourseRecord, String> {
}
