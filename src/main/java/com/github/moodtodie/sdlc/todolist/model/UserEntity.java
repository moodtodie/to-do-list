package com.github.moodtodie.sdlc.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long userId;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "passwd", nullable = false)
  private String password;

  public UserEntity() {
  }

  public UserEntity(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isExist() {
    return !username.isEmpty();
  }
}
