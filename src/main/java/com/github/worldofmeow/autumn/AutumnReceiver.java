package com.github.worldofmeow.autumn;

import java.util.function.BiConsumer;

public interface AutumnReceiver {
    default String getName() {
        return "Autumn_Generic";
    }
    boolean start();
    boolean stop();
    boolean isRunning();


    default void addHandler(BiConsumer<AutumnReceiver, Event> consumer) {

    }
}
