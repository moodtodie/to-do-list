package com.github.moodtodie.sdlc.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "tasks")
public class TaskEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long taskId;

  @Column(name = "task_text", nullable = false)
  private String text;

  @Column(name = "task_status", nullable = false)
  private boolean status;

  @Column(name = "fk_user_id", nullable = false)
  private Long fkUserId;

  public Long getTaskId() {
    return taskId;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Long getFkUserId() {
    return fkUserId;
  }

  public void setFkUserId(Long fkUserId) {
    this.fkUserId = fkUserId;
  }
}
