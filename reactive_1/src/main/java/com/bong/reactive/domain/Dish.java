package com.bong.reactive.domain;


import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Dish {
    private final String description;
    private final boolean delivered;

    private Dish(String description, boolean delivered) {
        this.description = description;
        this.delivered = delivered;
    }

    public Dish(String description) {
        this(description, false);
    }

    public static Dish deliver(Dish dish) {
        return new Dish(dish.description, true);
    }

    public String getDescription() {
        return description;
    }

    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "description='" + description + '\'' +
                ", delivered=" + delivered +
                '}';
    }
}
