package com.github.moodtodie.sdlc.todolist.service;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import com.github.moodtodie.sdlc.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  @Autowired
  TaskRepository repository;

  public void taskCompleted(Long taskId, boolean completed) {
    TaskEntity task = repository.getReferenceById(taskId);
    task.setCompleted(completed);
    repository.deleteById(taskId);
    repository.save(task);
  }

  public void addTask(String task) {
    repository.save(new TaskEntity(task, false));
  }

  public void deleteTask(Long id) {
    repository.deleteById(id);
  }

  public Iterable<TaskEntity> getAllTasks(){
    return repository.findAll();
  }
}
