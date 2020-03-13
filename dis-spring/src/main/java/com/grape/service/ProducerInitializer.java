package com.grape.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProducerInitializer {
    private final SubjectProducer subjectProducer;

    @Value("${subject.exchange}")
    private String exchange;

    @SneakyThrows
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        for(int i = 0; i < 100; ++i) {
            subjectProducer.produce(exchange);
            Thread.sleep(2000);
        }
    }
}
