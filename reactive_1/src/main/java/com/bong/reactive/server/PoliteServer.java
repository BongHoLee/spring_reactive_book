package com.bong.reactive.server;

import com.bong.reactive.Dish;
import com.bong.reactive.KitchenService;
import reactor.core.publisher.Flux;

public class PoliteServer implements Server<Dish>{
    private final KitchenService kitchen;

    public PoliteServer(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    @Override
    public Flux<Dish> doingMyJob() {
        return kitchen.getDishes()
                .doOnNext(dish -> System.out.println("Thnak you for " + dish + "!"))
                .doOnError(error -> System.out.println("So sorry about " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Thanks for all your hard work!"))
                .map(Dish::deliver)
                .doOnNext(dish -> System.out.println("publisher dish : " + dish));
    }
}
