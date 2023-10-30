package com.github.moodtodie.sdlc.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyPasswordEncoder {
  @Bean(name = "passwordEncoder")
  PasswordEncoder BCPasswordEncoder() {
    return new BCryptPasswordEncoder(11);
  }
}
