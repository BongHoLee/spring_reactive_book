package com.bong.reactive.reactive2.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class JpaDbProperties {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private boolean showSql;
    private boolean generateDdl;
    private String hibernateDialect;
}
