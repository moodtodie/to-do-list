package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import com.github.moodtodie.sdlc.todolist.repository.TaskRepository;
import com.github.moodtodie.sdlc.todolist.service.TaskService;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
  private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

  private TaskService service;

  public GreetingController(TaskService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String greeting() {
    return "greeting";
  }

  @GetMapping("/tasks")
  public String tasks(Model model) {
    model.addAttribute("tasks", service.getAllTasks());
    return "tasks";
  }

  @PostMapping("/tasks")
  public String add(@NotBlank @RequestParam String task, Model model){
    service.addTask(task);
    return "redirect:/tasks";
  }
}
