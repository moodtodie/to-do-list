package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.manager.TaskManager;
import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import com.github.moodtodie.sdlc.todolist.repository.TaskRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

  @Autowired
  private TaskRepository repository;

  @PostMapping("/add")
  public String add(@RequestParam(value = "task", defaultValue = "") String task) {
    if (task.isEmpty()) return "error";

    TaskManager.addTask(repository, task);

    return "greeting";
  }

  @PostMapping("/status")
  public String setStatus(@Valid @RequestParam(value = "id", defaultValue = "") Long id,
                          @Valid @RequestParam(value = "status", defaultValue = "false") boolean status) {
    TaskManager.setStatus(repository, id, status);
    return "greeting";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam(value = "id", defaultValue = "") Long id) {
    repository.deleteById(id);
    return "Deleted";
  }

  @GetMapping("/get")   //  FIX
  public String get(@Valid @RequestParam(value = "id", defaultValue = "") Long id) {
    return repository.getReferenceById(id).toString();
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<TaskEntity> getAll() {
    return repository.findAll();
  }
}
