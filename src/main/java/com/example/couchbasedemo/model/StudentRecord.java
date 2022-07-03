package com.example.couchbasedemo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.repository.Collection;

import java.util.List;

@Getter
@ToString
@Document
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Collection("student-record-collection")
public class StudentRecord {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String dateOfBirth;

    @Field
    private List<Enrollment> enrollments;
}
