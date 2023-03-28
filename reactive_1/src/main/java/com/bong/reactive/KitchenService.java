package com.bong.reactive;

import com.bong.reactive.domain.Dish;
import reactor.core.publisher.Flux;

public class KitchenService {
    public Flux<Dish> getDishes() {
        return Flux.just(
                new Dish("Sesame chicken"),
                new Dish("lo emin noddels, plain"),
                new Dish("Sweet & sour beef"));
    }

}
