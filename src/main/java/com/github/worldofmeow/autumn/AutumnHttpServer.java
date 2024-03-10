/*
 * Copyright (c) 2024. Justin Haag
 */

package com.github.worldofmeow.autumn;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.concurrent.*;

public class AutumnHttpServer {
    private ServerContext context;
    private HashMap<String, RequestHandler> handlers = new HashMap<>();
    public ServerContext getContext() {
        return context;
    }
    public AutumnHttpServer(ServerContext context) {
        this.context = context;
    }
    public boolean running() {
        if (server == null) { return false; }
        return true;
    }
    private HttpServer server;
    private AutumnHttpServer preChecksAndInit() {
        if(server == null) {
            try {
                server = HttpServer.create(
                                new InetSocketAddress(
                                        context.getAddress(),
                                        context.getPort()),
                                        context.getBackLog());
                if(context.getMaxThreads() == 1) {
                    server.setExecutor(new ThreadPoolExecutor(1, 1,
                            30L, TimeUnit.SECONDS, new LinkedBlockingQueue<>()));
                } else {
                    server.setExecutor(new ThreadPoolExecutor(0, context.getMaxThreads(),
                            60L, TimeUnit.SECONDS,
                            new SynchronousQueue<>()));
                }
                handlers.forEach((k, v) -> {
                    server.createContext(k, v);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            stop(0).preChecksAndInit();
        }
        return this;
    }
    public AutumnHttpServer hotSwap(ServerContext context, int maxTime) {
        stop(maxTime);
        this.context = context;
        return this;
    }
    public AutumnHttpServer hotSwap(ServerContext context) {
        return hotSwap(context, 0);
    }
    public AutumnHttpServer start() {
        if(!running()) {
            preChecksAndInit();
            server.start();
        }
        return this;
    }
    public AutumnHttpServer stop(int maxTime) {
        if(server != null) {
            server.stop(maxTime);
            server = null;
        }
        return this;
    }
    public AutumnHttpServer stop() {
        return stop(0);
    }
    public AutumnHttpServer setRoute(String route, RequestHandler handler) {
        removeRoute(route);
        handlers.put(route, handler);
        if (server != null) {
            server.createContext(route, handler);
        }
        return this;
    }
    public AutumnHttpServer removeRoute(String route) {
        if(handlers.containsKey(route)) {
            handlers.remove(route);
            if (server != null) {
                server.removeContext(route);
            }
        }
        return this;
    }
}
