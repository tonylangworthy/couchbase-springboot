package com.example.couchbasedemo.model;

import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;
import java.io.Serializable;
import lombok.NoArgsConstructor;

@Entity("CourseRecord")
@NoArgsConstructor
public class CourseRecord implements Serializable {

    @Id("id")
    private String id;

    private String courseName;

    private String faculty;

    private String creditPoints;

}
