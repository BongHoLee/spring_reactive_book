package com.bong.reactive.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {
    private static final String HOME = "home";

    @GetMapping
    Mono<String> home() {
        return Mono.just(HOME);
    }
}
