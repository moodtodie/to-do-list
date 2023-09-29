package com.github.moodtodie.sdlc.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.moodtodie.sdlc.todolist.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
