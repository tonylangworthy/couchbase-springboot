package com.langworthy.couchbasedemo.model;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Course {

    @Id
    private String id;

    @Field
    private String courseName;

    @Field
    private String faculty;

    @Field
    private String creditPoints;

    public Course() {
    }

    public Course(String courseName, String faculty, String creditPoints) {
        this.courseName = courseName;
        this.faculty = faculty;
        this.creditPoints = creditPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(String creditPoints) {
        this.creditPoints = creditPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(courseName, course.courseName) && Objects.equals(faculty, course.faculty) && Objects.equals(creditPoints, course.creditPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, faculty, creditPoints);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", creditPoints='" + creditPoints + '\'' +
                '}';
    }
}
