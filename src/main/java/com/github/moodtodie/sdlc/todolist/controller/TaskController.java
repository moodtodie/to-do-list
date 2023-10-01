package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.service.TaskService;
import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

  private TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping("/add")
  public String add(@RequestParam(value = "task", defaultValue = "") String task) {
    if (task.isEmpty()) return "error";
    service.addTask(task);
    return "redirect:/tasks";
  }

  @PostMapping("/completed")
  public String setStatus(@Valid @RequestParam(value = "id", defaultValue = "") Long id,
                          @Valid @RequestParam(value = "completed", defaultValue = "false") boolean completed) {
    service.taskCompleted(id, completed);
    return "success";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam(value = "id", defaultValue = "") Long id) {
    service.deleteTask(id);
    return "success";
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<TaskEntity> getAll() {
    return service.getAllTasks();
  }
}
