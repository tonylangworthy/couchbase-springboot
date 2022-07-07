package com.example.couchbasedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnrollmentDto {

    private String courseId;

    private String dateEnrolled;

    private String dateCompleted;
}
