package com.example.couchbasedemo.exception;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
