package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Configuration
@AllArgsConstructor
public class MessageRouterConfiguration {

    MessageEventService messageEventService;

    @Bean
    RouterFunction<ServerResponse> router() {
//        return route(GET("/fitness"), req -> ok().build())
//                .and(route(POST("/fitness"),
//                        request -> {}).build

        return route()
                .GET("/fitness", request -> {
                    return ServerResponse.ok().build();
                })
                .POST("/fitness", request -> {
                    final Flux<String> fitnessFlux = Flux.empty();
                    final String fitnessMessage = request.pathVariable("fitval");
                    messageEventService.sendMessage("simple-test-event");
                    return ServerResponse.accepted().build();
                })
                .build();
    }
}
