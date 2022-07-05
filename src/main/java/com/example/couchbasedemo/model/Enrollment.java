package com.example.couchbasedemo.model;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
public class Enrollment {

    private String id;

    private String dateEnrolled;

    private String dateCompleted;

    public Enrollment() {
    }

}
