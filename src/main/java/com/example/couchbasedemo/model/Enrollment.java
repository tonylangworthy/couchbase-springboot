package com.example.couchbasedemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Enrollment {

    private String courseId;

    private String dateEnrolled;

    private String dateCompleted;
}
