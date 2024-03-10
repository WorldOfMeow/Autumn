package com.github.worldofmeow.autumn;

import com.sun.net.httpserver.HttpExchange;

public class SimpleHttpExchange {
    private HttpExchange exchange;
    public HttpExchange getExchange() {
        return exchange;
    }

    public SimpleHttpExchange(HttpExchange exchange) {
        this.exchange = exchange;
    }
    public SimpleResponse simple() {
        return new SimpleResponse(this);
    }
}
