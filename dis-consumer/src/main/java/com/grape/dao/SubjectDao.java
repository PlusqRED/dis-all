package com.grape.dao;

import com.grape.model.Subject;

import java.util.List;

public interface SubjectDao {
    void save(Subject subject);

    void saveAverage(Subject subject);

    List<Subject> findAllAverage();

    List<Subject> findAll();

    long getCount();

    void clearSubjects();
}
