package com.example.couchbasedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentRecordDto {

    private String id;

    private String name;

    private String dateOfBirth;

    private List<EnrollmentDto> enrollments;
}
