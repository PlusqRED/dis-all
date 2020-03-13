package com.grape.service.impl;

import com.grape.model.Subject;
import com.grape.service.SubjectProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class RabbitSubjectProducer implements SubjectProducer {
    private final static Logger log = LoggerFactory.getLogger(RabbitSubjectProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void produce(String exchange) {
        Subject math = Subject.builder()
                .name("Math")
                .mark(new Random().nextInt(10))
                .localDateTime(LocalDateTime.now())
                .build();
        rabbitTemplate.convertAndSend(exchange, "subject.math", math);
        log.info(math + " was sent!");
    }
}
