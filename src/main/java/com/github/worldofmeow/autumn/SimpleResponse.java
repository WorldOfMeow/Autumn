/*
 * Copyright (c) 2024. github.com/WorldOfMeow
 */

package com.github.worldofmeow.autumn;

import java.io.IOException;
import java.io.OutputStream;

public class SimpleResponse {
    private SimpleHttpExchange simple;
    public SimpleHttpExchange getSimple() {
        return simple;
    }
    public SimpleResponse(SimpleHttpExchange exchange) {
        this.simple = exchange;
    }
    public Status returnPlainText(byte[] text, int code) {
        try {
            simple.getExchange().sendResponseHeaders(code, text.length);
            OutputStream os = simple.getExchange().getResponseBody();
            try {
                os.write(text);
            } catch (IOException e) {
                e.printStackTrace();
                return Status.ERROR;
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return Status.ERROR;
        }
        return Status.OK;
    }
    public Status returnPlainText(byte[] text) {
        return returnPlainText(text, ResponseCode.OK.code);
    }
    public Status returnPlainText(String text, int code) {
        return returnPlainText(text.getBytes(), code);
    }
    public Status returnPlainText(String text) {
        return returnPlainText(text.getBytes(), ResponseCode.OK.code);
    }
}
