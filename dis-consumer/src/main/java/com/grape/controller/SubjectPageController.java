package com.grape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/averageSubjects")
public class SubjectPageController {

    @GetMapping
    public String getSubjectsPage() {
        return "subjects";
    }
}
