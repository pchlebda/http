package com.sda.undertow;

import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HeaderMap;
import io.undertow.util.Headers;

public class Main {

    public static void main(String[] args) {
        int port = 8090;
        String host = "localhost";

        Undertow server = Undertow.builder()
                .addHttpListener(port, host, Main::handle)
                .build();
        server.start();
    }

    public static void handle(HttpServerExchange exchange) {
        HeaderMap headers = exchange.getRequestHeaders();

        System.out.println("Http headers:");
        System.out.println(headers);

        System.out.println("Http method:");
        System.out.println(exchange.getRequestMethod());

        System.out.println("Path:");
        System.out.println(exchange.getRelativePath());

        exchange.getResponseHeaders().add(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World!");
    }

}
