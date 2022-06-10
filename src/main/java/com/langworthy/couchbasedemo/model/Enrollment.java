package com.langworthy.couchbasedemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Enrollment {

    @Id
    private String id;

    @Field
    private String dateEnrolled;

    @Field
    private String dateCompleted;

}
