package com.bong.reactive.server;

import com.bong.reactive.domain.Dish;
import com.bong.reactive.KitchenService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ServerEntry {
    private static final String SERVER_PACKAGE = "com.bong.reactive.server.";

    public static Server<Dish> tonightServer(String name) {

        try {
            Class<?> serverClass = Class.forName(SERVER_PACKAGE + name);

            Constructor<?> declaredConstructor = serverClass.getDeclaredConstructor(KitchenService.class);

            return (Server<Dish>) declaredConstructor.newInstance(new KitchenService());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
