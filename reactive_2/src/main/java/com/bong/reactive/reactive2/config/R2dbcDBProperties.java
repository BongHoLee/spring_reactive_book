package com.bong.reactive.reactive2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.r2dbc")
@Data
public class R2dbcDBProperties {
    private String host;
    private String database;
    private String driver;
    private String url;
    private String username;
    private String password;
    private int port;
    private String protocol;
}

