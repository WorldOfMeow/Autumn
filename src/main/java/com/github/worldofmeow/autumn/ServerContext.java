/*
 * Copyright (c) 2024. Justin Haag
 */

package com.github.worldofmeow.autumn;

public class ServerContext {
    private String address = "localhost";
    private int port = 8080;
    private int backLog = 0;

    public int getMaxThreads() {
        return maxThreads;
    }

    /**
     * NOTE: Setting maxThreads to 0 will result in unlimited Threads size
     *     : For multithreaded applications a thread count of 4 - 16 is recommended
     * @param maxThreads
     */
    public void setMaxThreads(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    private int maxThreads = 4;
    private ServerContext() {}
    public int getBackLog() {
        return backLog;
    }
    public ServerContext setBackLog(int bl) {
        this.backLog = bl;
        return this;
    }
    public String getAddress() {
        return address;
    }
    public int getPort() {
        return port;
    }
    public AutumnHttpServer http() {
        return new AutumnHttpServer(this);
    }
    public static ServerContext create(String addr, int port) {
        ServerContext context = new ServerContext();
        context.address = addr;
        context.port = port;
        return context;
    }
    public static ServerContext blank() {
        return new ServerContext();
    }
}
