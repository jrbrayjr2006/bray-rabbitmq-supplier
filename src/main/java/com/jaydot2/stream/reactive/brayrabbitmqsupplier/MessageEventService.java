package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class MessageEventService {

    private Sinks.Many<String> unicastProcessor = Sinks.many().unicast().onBackpressureBuffer();

    public Flux<String> getProducer() {
        return unicastProcessor.asFlux();
    }

    public void sendMessage(String fitnessMessage) {
//        Message<String> message = MessageBuilder.withPayload(fitnessMessage).build();
        unicastProcessor.emitNext(fitnessMessage, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
