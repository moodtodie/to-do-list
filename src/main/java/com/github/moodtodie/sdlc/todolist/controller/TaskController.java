package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import com.github.moodtodie.sdlc.todolist.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Void> add(@NotBlank @RequestParam(value = "task", defaultValue = "") String task) {
    service.addTask(task);
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @PostMapping("/completed")
  public ResponseEntity<Void> setCompleted(@Valid @RequestParam(value = "id", defaultValue = "") Long id,
                                           @Valid @RequestParam(value = "completed", defaultValue = "false") boolean completed) {
    service.taskCompleted(id, completed);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @GetMapping("/delete")
  public ResponseEntity<Void> delete(@RequestParam(value = "id", defaultValue = "") Long id) {
    service.deleteTask(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @PostMapping("/{id}/completed")
  public ResponseEntity<Void> reverseCompleted(@PathVariable(value = "id") Long id) {
    service.taskCompleted(id, !service.getTask(id).isCompleted());
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @PostMapping("/{id}/delete")
  public ResponseEntity<Void> delete2(@PathVariable(value = "id") Long id) {
    service.deleteTask(id);
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<TaskEntity> getAll() {
    return service.getAllTasks();
  }
}
