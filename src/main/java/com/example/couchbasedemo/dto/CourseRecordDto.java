package com.example.couchbasedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseRecordDto {

    private String id;

    private String courseName;

    private String faculty;

    private String creditPoints;
}
