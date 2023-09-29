package com.github.moodtodie.sdlc.todolist.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/task")
public class TaskController {

  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

//    @Autowired
//    private TaskRepository taskRepository;

  @GetMapping("/add")
  public HttpStatus add(@Valid @RequestParam(value = "task", defaultValue = "") String task) {

    if (task.isEmpty()) return HttpStatus.BAD_REQUEST;

    logger.info("Getting add request | task=\"" + task + "\"");
//        taskRepository.save(new TaskEntity(new Task(0, task, false)));

    return HttpStatus.ACCEPTED;
  }

//  @PostMapping("/add")
//  public String addTask(@RequestBody String task) {
//    HttpStatus status = add(task.substring(5));
//    return (status.equals(HttpStatus.ACCEPTED)) ? "Задача успешно добавлена" : "Ошибка: Задача не добавлена!";
//  }

//    @GetMapping("/all")
//    public List<TaskEntity> getAll() {
//        return taskRepository.findAll();
//    }

//    @GetMapping("/add")
//    public HttpStatus add(@Valid @RequestParam(value = "task", defaultValue = "") String task) {
//
//        if (task.isEmpty())
//            return HttpStatus.BAD_REQUEST;
//
//        logger.info("Getting add request | task=\"" + task + "\"");
//        ToDoList.add(task);
//        taskRepository.save(new TaskEntity());
//
//        return HttpStatus.ACCEPTED;
//    }

//    @GetMapping("/get")
//    public String get(@Valid @RequestParam(value = "task_id", defaultValue = "-1") Long taskId) {
//        return (taskId != -1) ? ToDoList.get(taskId) : "null";
//    }

//    @GetMapping("/all")
//    public String[] getAll() {
//        return ToDoList.getList();
//    }
}
