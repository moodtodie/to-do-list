package com.github.moodtodie.sdlc.todolist.config;

import com.github.moodtodie.sdlc.todolist.model.Role;
import com.github.moodtodie.sdlc.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/tasks", "/api/task/add",
                "/api/task/completed", "/api/task/delete",
                "/api/task/*/completed", "/api/task/*/delete").authenticated()
            .requestMatchers("/api/task/all", "/api/user/**").hasRole(Role.ADMIN.name())
            .anyRequest().permitAll()
        )
        .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout(LogoutConfigurer::permitAll);

    return http.build();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth, UserService userService, PasswordEncoder passwordEncoder) throws Exception {
    auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
  }
}
