package com.github.worldofmeow.autumn;

public class AHttpReceiver implements AutumnReceiver {

    @Override
    public String getName() {
        return "Autumn_HttpReceiver-" + Autumn.versionString;
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public boolean stop() {
        return false;
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
