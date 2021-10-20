package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import reactor.core.publisher.Flux;

@Slf4j
@AllArgsConstructor
@Configuration
public class MessageConfiguration {

    @Bean
    public Supplier<Flux<Message<String>>> produceFitnessEvent(MessageEventService messageEventService) {
        return () -> messageEventService.getProducer();
    }
}
