package com.jaydot2.stream.reactive.brayrabbitmqsupplier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {"spring.cloud.stream.function.definition=produceFitnessEvent",
        "spring.cloud.bindings.produceFitnessEvent-out-0.destination=fitness-events"})
@DirtiesContext
public class MessageSupplierTest {

    @Test
    void fitnessEventEmittedTest() {
        //Given
        Message<String> message1 = MessageBuilder.withPayload("fitness1").build();
        Message<String> message2 = MessageBuilder.withPayload("fitness2").build();

        //When
        final Flux<Message<String>> messageFlux = Flux.just(message1, message2);

        //Then
        StepVerifier.create(messageFlux)
                .assertNext(message -> {
                    assertThat(message.getPayload()).isEqualTo("fitness1");
                })
                .assertNext(message -> {
                    assertThat(message.getPayload()).isEqualTo("fitness2");
                })
                .verifyComplete();
    }
}
