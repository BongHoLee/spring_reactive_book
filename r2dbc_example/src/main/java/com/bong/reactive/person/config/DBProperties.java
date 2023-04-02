package com.bong.reactive.person.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.r2dbc")
@Data
public class DBProperties {
    private String host;
    private String database;
    private String driver;
    private String url;
    private String username;
    private String password;
    private int port;
    private String protocol;
}

