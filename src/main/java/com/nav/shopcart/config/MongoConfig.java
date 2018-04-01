package com.nav.shopcart.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.nav.shopcart.dao"})
public class MongoConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongodbUri;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(mongodbUri));
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }
}
