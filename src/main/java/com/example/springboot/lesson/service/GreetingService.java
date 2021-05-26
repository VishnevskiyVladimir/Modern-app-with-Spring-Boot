package com.example.springboot.lesson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.services.greeting.message}")
    private String message;

    public String greeting() {
        return message;
    }
}
