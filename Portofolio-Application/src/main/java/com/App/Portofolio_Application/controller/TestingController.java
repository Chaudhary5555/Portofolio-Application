package com.App.Portofolio_Application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.App.Portofolio_Application.entity.Student;

import jakarta.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TestingController {

    private static final Logger logger = LoggerFactory.getLogger(TestingController.class);

    List<Student> st = new ArrayList<>(List.of(
            new Student(1, "sachin", 70),
            new Student(2, "Rahul", 75)));

    @GetMapping("/")
    public String test(HttpServletRequest request) {
        return "Hi Sachin Chaudhary " + request.getSession().getId();
    }

    @GetMapping("/st")
    public List<Student> getStudent() {

        return st;

    }

    @PostMapping("/st")
    public List<Student> postStudent(@RequestBody Student s) {
        // logger.info("coming " + s.toString());
        st.add(s);
        // logger.info("good");
        return st;

    }

    @GetMapping("/csrf")
    public CsrfToken token(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");

    }

}
