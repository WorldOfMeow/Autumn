package com.github.worldofmeow.autumn;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RequestHandler implements HttpHandler {
    @Override
    public final void handle(HttpExchange exchange) {
        request(new AHttpExchange(exchange));
    }
    public void request(AHttpExchange exchange) {

    }
}
