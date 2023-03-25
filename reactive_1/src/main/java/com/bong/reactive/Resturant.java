package com.bong.reactive;

import com.bong.reactive.server.Server;
import com.bong.reactive.server.ServerEntry;

public class Resturant {
    public static void main(String[] args) {
        Server<Dish> server = ServerEntry.tonightServer("PoliteServer");

        server.doingMyJob().subscribe(
                dish -> System.out.println("Consuming " + dish),
                System.out::println
        );
    }
}
