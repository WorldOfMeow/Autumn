package com.github.worldofmeow.autumn;

import com.sun.net.httpserver.HttpExchange;

public class AHttpExchange {
    private HttpExchange exchange;
    public HttpExchange getExchange() {
        return exchange;
    }

    public AHttpExchange(HttpExchange exchange) {
        this.exchange = exchange;
    }

    
}
