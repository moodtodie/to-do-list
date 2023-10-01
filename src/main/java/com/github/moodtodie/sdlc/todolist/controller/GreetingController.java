package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
  private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

  private TaskService service;

  public GreetingController(TaskService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String greeting() {
    return "redirect:/tasks";
  }

  @GetMapping("/tasks")
  public String tasks(Model model) {
    model.addAttribute("tasks", service.getAllTasks());
    return "tasks";
  }
}
