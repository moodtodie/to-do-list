package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.model.UserEntity;
import com.github.moodtodie.sdlc.todolist.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(name = "/user")
public class UserController {
  private final UserRepository repository;

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @PostMapping(path = "/add")
  public HttpStatus addUsers(@RequestParam String username, @RequestParam(name = "passwd") String password) {
    UserEntity user = new UserEntity();

    user.setUsername(username);
    user.setPassword(password);
    repository.save(user);

    logger.info(String.format("Added new user [username=\"%s\", password=\"%s\"]", username, password));

    return HttpStatus.ACCEPTED;
  }

  @GetMapping(path = "/all")
  public @ResponseBody Iterable<UserEntity> getAllUsers() {
    return repository.findAll();
  }
}
