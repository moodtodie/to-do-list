package com.github.moodtodie.sdlc.todolist.manager;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import com.github.moodtodie.sdlc.todolist.repository.TaskRepository;

public class TaskManager {
  public static void setStatus(TaskRepository repository, Long taskId, boolean status) {
    TaskEntity task = repository.getReferenceById(taskId);
    task.setStatus(status);
    repository.deleteById(taskId);
    repository.save(task);
  }

  public static void addTask(TaskRepository repository, String task) {
    repository.save(new TaskEntity(task, false));
  }
}
