package com.grape.controller;

import com.grape.dao.SubjectDao;
import com.grape.model.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectDao subjectDao;

    @GetMapping
    private ResponseEntity<List<Subject>> getSubjects() {
        return ResponseEntity.ok(subjectDao.findAll());
    }
}
