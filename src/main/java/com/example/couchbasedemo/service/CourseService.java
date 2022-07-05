package com.example.couchbasedemo.service;

import com.example.couchbasedemo.model.CourseRecord;
import com.example.couchbasedemo.repository.CourseRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("CourseService")
@RequiredArgsConstructor
public class CourseService {

    private final CourseRecordRepository courseRecordRepository;

    public CourseRecord create(CourseRecord courseRecord) {
        return courseRecordRepository.save(courseRecord);
    }

    public List<CourseRecord> fetchAllCourses() {
        return courseRecordRepository.findAll();
    }
}
