package com.github.worldofmeow.autumn;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

public class AHttpReceiver implements AutumnReceiver {

    private ServerContext context;

    @Override
    public String getName() {
        return "Autumn_HttpReceiver-" + Autumn.versionString;
    }

    public AHttpReceiver setContext(ServerContext context) {
        this.context = context;
        return this;
    }

    @Override
    public boolean start() {
        if(!isRunning()) {
            if(context == null) {
                context = ServerContext.blank();
            }
            try {
                HttpServer server = HttpServer.create();
                server.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
