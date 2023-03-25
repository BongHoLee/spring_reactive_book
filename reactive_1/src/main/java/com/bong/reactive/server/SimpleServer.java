package com.bong.reactive.server;

import com.bong.reactive.Dish;
import com.bong.reactive.KitchenService;
import reactor.core.publisher.Flux;

public class SimpleServer implements Server<Dish>{
    private final KitchenService kitchen;

    public SimpleServer(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public Flux<Dish> doingMyJob() {
        return this.kitchen.getDishes()
                .map(Dish::deliver);
    }
}
