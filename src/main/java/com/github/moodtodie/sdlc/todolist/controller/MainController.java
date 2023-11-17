package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.service.TaskService;
import com.github.moodtodie.sdlc.todolist.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
  private static final Logger logger = LoggerFactory.getLogger(MainController.class);

  private final TaskService service;
  private final UserService uService;

  public MainController(TaskService service, UserService uService) {
    this.service = service;
    this.uService = uService;
  }

  @GetMapping("/")
  public String root() {
    return "redirect:/tasks";
  }

  @GetMapping("/tasks")
  @PreAuthorize("isAuthenticated()")
  public String tasks(Model model, Principal principal) {
    var uid = uService.findUser(principal.getName()).getUserId();
    logger.info(String.format("name: \"%s\", id: %d, role: \"%s\"", principal.getName()
        , uid, uService.findUser(principal.getName()).getRole()));

    model.addAttribute("tasks", service.getTasksByUserId(uid));
    return "tasks";
  }
}
