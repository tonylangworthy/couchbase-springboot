package com.example.couchbasedemo.dto;

import lombok.Data;

@Data
public class StudentRecordDto {

    private String id;

    private String name;

    private String dateOfBirth;

//    private Map<String, EnrollmentDto> enrollments;
}
