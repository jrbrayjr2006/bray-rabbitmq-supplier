package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Slf4j
@AllArgsConstructor
@Configuration
public class MessageConfiguration {

    @Bean
    public Supplier<Flux<Message<String>>> produceFitnessEvent(MessageEventService messageEventService) {
        return () -> messageEventService.getProducer().asFlux();
    }
}
