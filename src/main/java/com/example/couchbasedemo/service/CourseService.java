package com.example.couchbasedemo.service;

import com.example.couchbasedemo.exception.CourseNotFoundException;
import com.example.couchbasedemo.model.CourseRecord;
import com.example.couchbasedemo.repository.CourseRecordRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("CourseService")
public class CourseService {

    private final CourseRecordRepository courseRecordRepository;

    public CourseRecord create(CourseRecord courseRecord) {
        return courseRecordRepository.save(courseRecord);
    }

    public List<CourseRecord> fetchAllCourses() {
        return courseRecordRepository.findAll();
    }

    public CourseRecord findByCourseId(String courseId) {
        Optional<CourseRecord> optionalCourseRecord = courseRecordRepository.findById(courseId);
        return optionalCourseRecord.orElseThrow(CourseNotFoundException::new);
    }
}
