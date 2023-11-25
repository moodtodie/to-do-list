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

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping("/add")
  public ResponseEntity<Void> add(@Valid @RequestParam(value = "uid", defaultValue = "0") Long uid,
                                  @NotBlank @RequestParam(value = "task", defaultValue = "") String task) {
    service.addTask(uid, task);
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
    logger.info("Task No." + id + " changed status");
    service.taskCompleted(id, !service.getTask(id).isCompleted());
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @PostMapping("/{id}/edit/")
  public ResponseEntity<Void> edit(@PathVariable(value = "id") Long id, @RequestParam(value = "text") @NotBlank String text) {
    logger.info("Task No." + id + " has been changed to \"" + text + "\"");
    service.editTask(id, text);
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @PostMapping("/{id}/delete")
  public ResponseEntity<Void> delete2(@PathVariable(value = "id") Long id) {
    logger.info("Task No." + id + " has been deleted");
    service.deleteTask(id);
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
  }

  @GetMapping("/all")
  public @ResponseBody Iterable<TaskEntity> getAll() {
    return service.getAllTasks();
  }
}
