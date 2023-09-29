package com.github.moodtodie.sdlc.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.moodtodie.sdlc.todolist.model.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
