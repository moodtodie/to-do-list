package com.github.moodtodie.sdlc.todolist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "passwd", nullable = false)
  private String password;

  @Column(name = "role", nullable = false)
  private String role;

  public UserEntity() {
  }

  public UserEntity(String username, String password) {
    this.username = username;
    this.password = password;
    this.role = Role.USER.name();
  }

  public Long getUserId() {
    return userId;
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

  public String getRole() {
    return role;
  }
}
