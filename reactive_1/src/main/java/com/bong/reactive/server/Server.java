package com.bong.reactive.server;

import reactor.core.publisher.Flux;

public interface Server<T> {
    Flux<T> doingMyJob();
}
