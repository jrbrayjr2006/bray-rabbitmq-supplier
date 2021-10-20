package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Configuration
@AllArgsConstructor
public class MessageRouterConfiguration {

//    MessageEventService messageEventService;

    @Bean
    RouterFunction<ServerResponse> createFitnessExercise(MessageEventHandler messageEventHandler) {
        return route(GET("/fitness").and(accept(MediaType.APPLICATION_JSON)), messageEventHandler::sendDefaultMessage);
    }
}
