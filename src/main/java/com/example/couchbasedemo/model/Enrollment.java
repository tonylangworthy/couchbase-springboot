package com.example.couchbasedemo.model;

import jakarta.nosql.mapping.Id;
import java.io.Serializable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Enrollment implements Serializable {

    @Id
    private String id;

    private String dateEnrolled;

    private String dateCompleted;

}
