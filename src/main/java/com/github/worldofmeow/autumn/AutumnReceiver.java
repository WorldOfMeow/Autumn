package com.github.worldofmeow.autumn;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public interface AutumnReceiver {
    default String getName() {
        return "Autumn_Generic";
    }
    boolean start();
    boolean stop();
    boolean isRunning();
    List<BiConsumer<AutumnReceiver, ReceiverEvent>> handlers = new ArrayList<>();
    default void addHandler(BiConsumer<AutumnReceiver, ReceiverEvent> handler) {
        if(!handlers.contains(handler)) {
            handlers.add(handler);
        }
    }
    default Iterator<BiConsumer<AutumnReceiver, ReceiverEvent>> getHandlers() {
        return handlers.iterator();
    }
}
