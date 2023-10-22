package com.github.moodtodie.sdlc.todolist.service;

import com.github.moodtodie.sdlc.todolist.model.UserEntity;
import com.github.moodtodie.sdlc.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository repository;

  public boolean addUser(String username, String email, String password) {
    if (!findUser(username).isExist())
      return false;
//    repository.save(new UserEntity(username, email, password));
    repository.save(new UserEntity(username, password));
    return true;
  }

  public boolean logInUser(String username, String password) {
    UserEntity user = findUser(username);
    return user.isExist() && user.getPassword().equals(password);
//    repository.save(new UserEntity(username, password));
  }

  public boolean deleteUser(String username, String password) {
    UserEntity user = findUser(username);
    if (!user.isExist() || !user.getPassword().equals(password))
      return false;

    repository.delete(user);
    return true;
  }

  public UserEntity findUser(String username) {
    return repository.findByUsername(username);
//    return repository.getById(0L);
  }

//  public Long getUserId() {
//    return 0L;
//  }
}
