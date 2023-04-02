package com.bong.reactive.person.domain.post;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostRepository extends R2dbcRepository<Post,  String> {
    Flux<Post> findByTitleContains(String name);
    Mono<Long> countByTitleContains(String name);
}
