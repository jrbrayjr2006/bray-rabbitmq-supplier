package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Slf4j
@AllArgsConstructor
@Configuration
public class MessageConfiguration {

    private MessageEventService messageEventService;

    @Bean
    public Supplier<Flux<String>> produceFitnessEvent() {
        messageEventService.sendMessage("some-event1");
        return new Supplier() {
            @Override
            public Object get() {
                return messageEventService.getProducer();
            }
        };
    }
}
