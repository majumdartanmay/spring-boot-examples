package com.spring.session.example.sessionexample.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    @GetMapping("/hello")
    public String helloWorld() {
        return "OK";
    }
}
