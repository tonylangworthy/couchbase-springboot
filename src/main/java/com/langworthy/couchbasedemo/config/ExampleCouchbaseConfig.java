package com.langworthy.couchbasedemo.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages={"com.langworthy.couchbasedemo"})
public class ExampleCouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "localhost";
    }

    @Override
    public String getUserName() {
        return "Administrator";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getBucketName() {
        return "student-bucket";
    }
}
