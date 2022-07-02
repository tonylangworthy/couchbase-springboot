package com.example.couchbasedemo.dto;

import java.util.Map;
import lombok.Data;

@Data
public class StudentRecordDto {

    private String id;

    private String name;

    private String dateOfBirth;

    private Map<String, String> enrollments;

}
