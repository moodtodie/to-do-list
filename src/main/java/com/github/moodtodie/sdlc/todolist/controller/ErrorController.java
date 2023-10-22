package com.github.moodtodie.sdlc.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
  //  Access is denied
  @GetMapping("/403")
  public String error403() {
    return "/error/403";
  }

  //  Not Found
  @GetMapping("/404")
  public String error404() {
    return "/error/404";
  }
}
