package com.example.couchbasedemo.model;

import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import java.io.Serializable;
import java.util.Map;
import lombok.NoArgsConstructor;

@Entity("StudentRecord")
@NoArgsConstructor
public class StudentRecord implements Serializable {

    @Id("id")
    private String id;

    private String name;

    private String dateOfBirth;

    private Map<String, Enrollment> enrollments;

}
