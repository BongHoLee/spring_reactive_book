package com.bong.reactive.server;

import com.bong.reactive.Dish;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ServerEntryTest {

    @Test
    void createTest() {
        Server<Dish> politeServer = ServerEntry.tonightServer("PoliteServer");
        Server<Dish> simpleServer = ServerEntry.tonightServer("SimpleServer");

        Assertions.assertThat(politeServer).isInstanceOf(PoliteServer.class);
        Assertions.assertThat(simpleServer).isInstanceOf(SimpleServer.class);
    }
}