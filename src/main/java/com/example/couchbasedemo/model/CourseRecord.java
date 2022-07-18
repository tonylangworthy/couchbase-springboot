package com.example.couchbasedemo.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;

@Getter
@ToString
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Collection("course-record-collection")
public class CourseRecord {

    @Id
    private String id;

    @Field
    private String courseName;

    @Field
    private String faculty;

    @Field
    private Integer creditPoints;
}
