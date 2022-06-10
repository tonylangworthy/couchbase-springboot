package com.langworthy.couchbasedemo.repository;

import com.langworthy.couchbasedemo.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
}
