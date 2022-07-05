package com.example.couchbasedemo.model;

import java.util.Objects;
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

    public Enrollment() {
    }

    public Enrollment(String dateEnrolled, String dateCompleted) {
        this.dateEnrolled = dateEnrolled;
        this.dateCompleted = dateCompleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Enrollment that = (Enrollment) o;
        return Objects.equals(id, that.id) && Objects.equals(dateEnrolled, that.dateEnrolled) && Objects.equals(dateCompleted, that.dateCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateEnrolled, dateCompleted);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id='" + id + '\'' +
                ", dateEnrolled='" + dateEnrolled + '\'' +
                ", dateCompleted='" + dateCompleted + '\'' +
                '}';
    }
}
