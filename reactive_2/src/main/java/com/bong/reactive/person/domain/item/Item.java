package com.bong.reactive.person.domain.item;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("items")
@Getter
@Builder
public class Item {

    @Id
    private String id;
    private String name;
    private double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
