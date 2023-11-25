package com.github.moodtodie.sdlc.todolist.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long taskId;

  @Column(name = "task_text", nullable = false)
  private String text;

  @Column(name = "task_status", nullable = false)
  private boolean completed;

  @Column(name = "fk_user_id", nullable = false)
  private Long fkUserId;

  public TaskEntity() {
    this.completed = false;
  }

  public TaskEntity(Long uid, String text, boolean completed) {
    this.text = text;
    this.completed = completed;
    this.fkUserId = uid;
  }

  public TaskEntity(String text, boolean completed, Long userId) {
    this.text = text;
    this.completed = completed;
    this.fkUserId = userId;
  }

  public Long getTaskId() {
    return taskId;
  }

  public String getText() {
    return text;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public Long getFkUserId() {
    return fkUserId;
  }
}
