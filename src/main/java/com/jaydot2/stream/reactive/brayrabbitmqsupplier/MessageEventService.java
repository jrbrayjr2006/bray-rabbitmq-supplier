package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class MessageEventService {

    private Sinks.Many<Message<String>> unicastProcessor = Sinks.many().unicast().onBackpressureBuffer();

    public Sinks.Many<Message<String>> getProducer() {
        return unicastProcessor;
    }

    public void sendMessage(String fitnessMessage) {
        Message<String> message = MessageBuilder.withPayload(fitnessMessage).build();
        unicastProcessor.emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST);
    }

}
