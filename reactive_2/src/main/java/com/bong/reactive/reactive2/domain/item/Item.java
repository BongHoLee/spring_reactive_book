package com.bong.reactive.reactive2.domain.item;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import org.springframework.data.relational.core.mapping.Table;

@Entity(name = "items")
@Table(name = "items")
@Getter
public class Item {

    @Id
    @org.springframework.data.annotation.Id
    private String id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this(UUID.randomUUID().toString(), name, price);
    }

    public Item(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {}
}
