package ru.naumow;

import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// https://www.logicbig.com/tutorials/spring-framework/spring-data/web-query-dsl-collection-properties.html
@SpringBootApplication
@EnableMongoRepositories
public class QueryDslDemoApplication {

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create(), "local");
    }

    public static void main(String[] args) {
        SpringApplication.run(QueryDslDemoApplication.class, args);
    }

}
