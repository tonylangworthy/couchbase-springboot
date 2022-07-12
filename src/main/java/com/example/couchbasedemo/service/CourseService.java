package com.example.couchbasedemo.service;

import com.example.couchbasedemo.dto.CourseRecordDto;
import com.example.couchbasedemo.exception.CourseNotFoundException;
import com.example.couchbasedemo.model.CourseRecord;
import com.example.couchbasedemo.repository.CourseRecordRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Qualifier("CourseService")
public class CourseService {

    private final CourseRecordRepository courseRecordRepository;

    public CourseRecordDto create(CourseRecordDto courseRecordDto) {
        CourseRecord newCourseRecord = new CourseRecord(
                courseRecordDto.getId(), courseRecordDto.getCourseName(), courseRecordDto.getFaculty(),
                courseRecordDto.getCreditPoints());

        CourseRecord savedCourseRecord = courseRecordRepository.save(newCourseRecord);

        return new CourseRecordDto(savedCourseRecord.getId(), savedCourseRecord.getCourseName(),
                savedCourseRecord.getFaculty(), savedCourseRecord.getCreditPoints());
    }

    public List<CourseRecordDto> fetchAllCourses() {
        List<CourseRecord> courseRecordList = courseRecordRepository.findAll();

        return courseRecordList.stream().map(course -> {
            log.info("Course Name: {}", course.getCourseName());
            return new CourseRecordDto(
                    course.getId(), course.getCourseName(), course.getFaculty(), course.getCreditPoints());
        }).collect(Collectors.toList());
    }

    public CourseRecordDto findByCourseId(String courseId) {
        Optional<CourseRecord> optionalCourseRecord = courseRecordRepository.findById(courseId);

        CourseRecord courseRecord = optionalCourseRecord.orElseThrow(CourseNotFoundException::new);

        return new CourseRecordDto(courseRecord.getId(), courseRecord.getCourseName(),
                courseRecord.getFaculty(), courseRecord.getCreditPoints());
    }
}
