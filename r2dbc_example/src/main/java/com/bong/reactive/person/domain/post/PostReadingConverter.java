package com.bong.reactive.person.domain.post;

import io.r2dbc.spi.Row;
import java.time.LocalDateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class PostReadingConverter implements Converter<Row, Post> {
    @Override
    public Post convert(Row row) {
        return Post.builder()
                .id(row.get("id", String.class))
                .title(row.get("title", String.class))
                .content(row.get("content", String.class))
                .status(row.get("status", Post.Status.class))
                .metadata(row.get("metadata", String.class))
                .createdAt(row.get("created_at", LocalDateTime.class))
                .updatedAt(row.get("updated_at", LocalDateTime.class))
                .version(row.get("version", Long.class))
                .build();
    }
}
