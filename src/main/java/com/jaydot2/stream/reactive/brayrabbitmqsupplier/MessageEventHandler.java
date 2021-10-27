package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class MessageEventHandler {

    private final MessageEventService messageEventService;

    public Mono<ServerResponse> sendDefaultMessage(ServerRequest serverRequest) {

        messageEventService.sendMessage("fitness-success");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{\"result\":\"ok\"}"));
    }
}
