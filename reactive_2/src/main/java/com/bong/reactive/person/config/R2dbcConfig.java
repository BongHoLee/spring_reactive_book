package com.bong.reactive.person.config;

import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.PROTOCOL;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;
import static io.r2dbc.spi.ConnectionFactoryOptions.builder;

import io.r2dbc.spi.ConnectionFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableR2dbcAuditing
@EnableTransactionManagement
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    private final DBProperties properties;

    public R2dbcConfig(DBProperties properties) {
        this.properties = properties;
    }


    @NotNull
    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactoryBuilder.withOptions(
                builder()
                        .option(HOST, properties.getHost())
                        .option(DATABASE, properties.getDatabase())
                        .option(PORT, properties.getPort())
                        .option(USER, properties.getUsername())
                        .option(PASSWORD, properties.getPassword())
                        .option(DRIVER, properties.getDriver())
                        .option(PROTOCOL, properties.getProtocol())
        ).build();
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
