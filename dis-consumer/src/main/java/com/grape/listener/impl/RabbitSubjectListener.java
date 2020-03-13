package com.grape.listener.impl;

import com.grape.dao.SubjectDao;
import com.grape.listener.SubjectListener;
import com.grape.model.Subject;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitSubjectListener implements SubjectListener {
    private static final Logger logger = LoggerFactory.getLogger(RabbitSubjectListener.class);
    private final SubjectDao subjectDao;
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "${subject.exchange}"),
            key = "subject.math"
    ))
    @Override
    public void listenSubject(Subject subject) {
        logger.info(subject + " was delivered!");
        subjectDao.save(subject);
        if(subjectDao.getCount() == 3) {
            subjectDao.findAll()
                    .stream()
                    .reduce(this::calculateAverageMark)
                    .ifPresent(subjectDao::saveAverage);
            subjectDao.clearSubjects();
        }
    }

    private Subject calculateAverageMark(Subject subject, Subject subject1) {
        return Subject.builder()
                .name(subject.getName())
                .localDateTime(subject1.getLocalDateTime())
                .mark((subject.getMark() + subject1.getMark()) / 2)
                .build();
    }
}
