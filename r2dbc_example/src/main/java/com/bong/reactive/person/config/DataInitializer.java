package com.bong.reactive.person.config;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {
    private final DatabaseClient databaseClient;

    @EventListener(value = ContextRefreshedEvent.class)
    public void init() throws Exception {
        log.info("start data initialization ...");
        databaseClient
                .sql("INSERT INTO posts (id, title, content, metadata) VALUES (:id, :title, :content, :metadata)")
                .bind("id", UUID.randomUUID().toString())
                .bind("title", "my_first_post")
                .bind("content", "content of my first post")
                .bind("metadata", "{\"tags\":[\"spring\", \"r2dbc\"]}")
                .fetch()
                .first()
                .subscribe(
                        data -> log.info("inserted data : {}", data),
                        error -> log.error("error : {}", error)
                );
    }
}
