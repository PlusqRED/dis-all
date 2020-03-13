package com.grape.dao.impl;

import com.grape.dao.SubjectDao;
import com.grape.model.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InMemorySubjectDao implements SubjectDao {

    private List<Subject> subjects = new ArrayList<>();
    private List<Subject> averageSubjects = new ArrayList<>();

    @Override
    public void save(Subject subject) {
        subjects.add(subject);
    }

    @Override
    public void saveAverage(Subject subject) {
        averageSubjects.add(subject);
    }

    @Override
    public List<Subject> findAllAverage() {
        List<Subject> unmodifiableList = new ArrayList<>();
        Collections.copy(unmodifiableList, averageSubjects);
        return Collections.unmodifiableList(unmodifiableList);
    }

    @Override
    public List<Subject> findAll() {
        return Collections.unmodifiableList(subjects);
    }

    @Override
    public long getCount() {
        return subjects.size();
    }

    @Override
    public void clearSubjects() {
        subjects.clear();
    }


}
