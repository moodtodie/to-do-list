package com.github.moodtodie.sdlc.todolist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/tasks", "/403", "/api/task/**").authenticated()
//            .requestMatchers("/api/task/all").hasRole("ADMIN")
            .anyRequest().permitAll()
        )
        .formLogin((form) -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout(LogoutConfigurer::permitAll);

    return http.build();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("tester")
        .password("testme")
        .roles("USER")
        .build();

    UserDetails user2 = User.withDefaultPasswordEncoder()
        .username("sa")
        .password("root")
        .roles("USER")
        .build();

//    UserDetails admin = User.withDefaultPasswordEncoder()
//        .username("admin")
//        .password("admin")
//        .roles("ADMIN")
//        .build();
    return new InMemoryUserDetailsManager(user, user2);
  }
}
