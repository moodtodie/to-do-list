package com.github.moodtodie.sdlc.todolist.repository;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
  List<TaskEntity> findAllByFkUserId(Long userId);
}
