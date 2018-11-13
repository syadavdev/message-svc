package com.sandi.message.config;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MongoDBConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoDbUri;

    @Bean
    @Autowired
    public Mongobee mongobee(Environment environment){
        return new Mongobee(mongoDbUri).setSpringEnvironment(environment).setChangeLogsScanPackage("com.sandi.message.changelogs");
    }

    public void setMongoDbUri(String mongoDbUri){
        this.mongoDbUri = mongoDbUri;
    }

}
