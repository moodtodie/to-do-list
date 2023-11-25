package com.github.moodtodie.sdlc.todolist.dto;

import com.github.moodtodie.sdlc.todolist.model.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDto {
  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;
  private String matchingPassword;

  @NotNull
  @NotEmpty
  private String role = Role.USER.name();

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

  public String getMatchingPassword() {
    return matchingPassword;
  }

  public void setMatchingPassword(String matchingPassword) {
    this.matchingPassword = matchingPassword;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
