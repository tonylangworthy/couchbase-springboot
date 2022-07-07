package com.example.couchbasedemo.exception;

import java.util.function.Supplier;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super();
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
