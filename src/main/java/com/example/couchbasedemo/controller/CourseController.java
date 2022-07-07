package com.example.couchbasedemo.controller;

import com.example.couchbasedemo.dto.CourseRecordDto;
import com.example.couchbasedemo.exception.CourseNotFoundException;
import com.example.couchbasedemo.model.CourseRecord;
import com.example.couchbasedemo.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public List<CourseRecordDto> listAllCourses() {
        List<CourseRecord> courseRecordList = courseService.fetchAllCourses();

        return courseRecordList.stream().map(course -> {
            log.info("Course Name: {}", course.getCourseName());
            return new CourseRecordDto(
                    course.getId(), course.getCourseName(), course.getFaculty(), course.getCreditPoints());
        }).collect(Collectors.toList());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseRecordDto> getCourseById(@PathVariable String id) {
        log.info("Fetching student with id: {}", id);

        CourseRecord courseRecord;

        try {
            courseRecord = courseService.findByCourseId(id);

        } catch (CourseNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        CourseRecordDto courseRecordDto = new CourseRecordDto(courseRecord.getId(), courseRecord.getCourseName(),
                courseRecord.getFaculty(), courseRecord.getCreditPoints());
        return ResponseEntity.ok(courseRecordDto);
    }


    @PostMapping("/courses")
    public void createCourse(@RequestBody CourseRecordDto courseRecordDto) {
        log.info("Course submitted: {}", courseRecordDto.toString());

        CourseRecord newCourseRecord = new CourseRecord(
                courseRecordDto.getId(), courseRecordDto.getCourseName(), courseRecordDto.getFaculty(),
                courseRecordDto.getCreditPoints());

        courseService.create(newCourseRecord);
    }
}
