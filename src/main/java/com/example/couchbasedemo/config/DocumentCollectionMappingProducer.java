package com.example.couchbasedemo.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.nosql.Settings;
import jakarta.nosql.document.DocumentCollectionManager;
import jakarta.nosql.document.DocumentCollectionManagerFactory;
import jakarta.nosql.document.DocumentConfiguration;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.eclipse.jnosql.communication.couchbase.document.CouchbaseDocumentConfiguration;

@ApplicationScoped
public class DocumentCollectionMappingProducer {

    private static final String BUCKET = "student-bucket";

    private DocumentConfiguration configuration;

    private DocumentCollectionManagerFactory managerFactory;

    @PostConstruct
    public void init() {
        configuration = new CouchbaseDocumentConfiguration();
        Map<String, Object> settings = new HashMap<>();
        settings.put("couchbase.host", "localhost");
        settings.put("couchbase.user", "admin");
        settings.put("couchbase.password", "password");
        managerFactory = configuration.get(Settings.of(settings));
    }


    @Produces
    public DocumentCollectionManager getBucket() {
        return managerFactory.get(BUCKET);

    }
}
