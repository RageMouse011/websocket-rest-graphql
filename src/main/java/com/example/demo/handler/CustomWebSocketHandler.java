package com.example.demo.handler;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Component
@AllArgsConstructor
public class CustomWebSocketHandler implements WebSocketHandler {

    private final Sinks.Many<String> sink;

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        var f = sink.asFlux()
                .map(s -> session.textMessage(s));

        return session.send(f);
    }
}
