package com.github.moodtodie.sdlc.todolist.controller;

import com.github.moodtodie.sdlc.todolist.service.UserService;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

//  @PostMapping("/add")
//  public ResponseEntity<Void> add(@NotBlank @RequestParam(value = "username", defaultValue = "") String username,
//                                  @NotBlank @RequestParam(value = "email", defaultValue = "") String email,
//                                  @NotBlank @RequestParam(value = "password", defaultValue = "") String password) {
//    if (service.addUser(username, email, password))
//      return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
//    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/error").build();
//  }

  @PostMapping("/login")
  public ResponseEntity<Void> logIn(@NotBlank @RequestParam(value = "username", defaultValue = "") String username,
                                    @NotBlank @RequestParam(value = "password", defaultValue = "") String password) {
    logger.warn("Can't log in (need make function)");
    if (service.logInUser(username, password))
      return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/error").build();
  }

//  @PostMapping("/delete")
//  public ResponseEntity<Void> delete(@NotBlank @RequestParam(value = "username", defaultValue = "") String username,
//                                     @NotBlank @RequestParam(value = "password", defaultValue = "") String password) {
//    if (service.deleteUser(username, password))
//      return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/tasks").build();
//    return ResponseEntity.status(HttpStatus.FOUND).header("Location", "/error").build();
//  }
}
