package com.example.springboot.lesson.config;

import com.example.springboot.lesson.conditional.FirstConditional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Conditional(FirstConditional.class)
@Configuration
public class ApplicationConfiguration {
    @PostConstruct
    public void init() {
        log.warn("our configuration is loaded");
    }
}
