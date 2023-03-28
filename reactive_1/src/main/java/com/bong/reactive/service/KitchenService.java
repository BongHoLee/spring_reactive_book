package com.bong.reactive.service;

import com.bong.reactive.domain.Dish;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class KitchenService {
    private static final Random PICKER = new Random();

    /**
     * 요리 스트림 생성
     * 250ms 간격으로 요리를 계속 제공 (Flux.just는 고정적인 목록의 Dish를 만들어준것과 대비)
     * Flux.<T> generate(Consumer<SynchronousSink<T>> generator)에서 Consumer<SynchronousSink<T>>는 Flux의 핸들러로써 Flux에 포함될 데이터를 동적으로 발행
     */
    public Flux<Dish> getDishes() {
        return Flux.<Dish> generate(sink -> sink.next(randomDish()))
                .delayElements(Duration.ofMillis(250));
    }

    /**
     * 요리 무작위 선택
     */
    private Dish randomDish() {
        List<Dish> menu = menu();
        return menu.get(PICKER.nextInt(menu.size()));
    }

    private List<Dish> menu() {
        return List.of(
                new Dish("sesame chicken"),
                new Dish("Lo mein noodles, plain"),
                new Dish("Sweet & sour beef"));
    }

}
