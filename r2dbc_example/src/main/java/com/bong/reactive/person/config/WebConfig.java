package com.bong.reactive.person.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.bong.reactive.person.domain.post.PostHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebConfig implements WebFluxConfigurer {
    private final ObjectMapper objectMapper;

    public WebConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
        configurer.defaultCodecs()
                .jackson2JsonEncoder(
                        new Jackson2JsonEncoder(objectMapper, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
        configurer.defaultCodecs()
                .jackson2JsonDecoder(
                        new Jackson2JsonDecoder(objectMapper, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));
    }

    @Bean
    public RouterFunction<ServerResponse> routes(PostHandler postController) {
        return route()
                .path("/posts", () -> route()
                        .nest(
                                path(""),
                                () -> route()
                                        .GET("", postController::all)
                                        .POST("", postController::create)
                                        .build()
                        )
                        .nest(
                                path("{id}"),
                                () -> route()
                                        .GET("", postController::get)
                                        .build()

                        )
                        .nest(
                                path("title"),
                                () -> route()
                                        .GET("{title}", postController::findByTitle)
                                        .build()
                        )
                        .build()
                ).build();
    }
}
