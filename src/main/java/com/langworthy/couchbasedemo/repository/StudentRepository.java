package com.langworthy.couchbasedemo.repository;

import com.langworthy.couchbasedemo.model.Student;
import java.util.List;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCouchbaseRepository<Student, String> {

    Flux<Student> findAll();
}
