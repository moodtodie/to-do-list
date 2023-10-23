package com.github.moodtodie.sdlc.todolist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/").setViewName("tasks");
    registry.addViewController("/tasks").setViewName("tasks");
    registry.addViewController("/login").setViewName("login");
  }
}