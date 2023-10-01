package com.github.moodtodie.sdlc.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
  @GetMapping("/")
  public String greeting() {
    return "greeting";
  }

  @GetMapping("/tasks")
  public String taskList() {
    return "task_list";
  }
}
