package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.service.TaskService;
import com.github.moodtodie.sdlc.todolist.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
  private static final Logger logger = LoggerFactory.getLogger(MainController.class);

  private final TaskService service;
  private final UserService uService;

  public MainController(TaskService service, UserService uService) {
    this.service = service;
    this.uService = uService;
  }

  @GetMapping("/test")
  public String test(Model model) {
    Long uid = uService.getUserId();
    logger.info(String.format("current user_id is %d", uid));
    model.addAttribute("tasks", service.getTasksByUserId(uid));
    return "redirect:/tasks";
  }

  @GetMapping("/tasks")
  public String tasks(Model model) {
    model.addAttribute("tasks", service.getAllTasks());
    return "tasks";
  }
}
