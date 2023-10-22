package com.github.moodtodie.sdlc.todolist.repository;

import com.github.moodtodie.sdlc.todolist.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUsername(String username);
}
