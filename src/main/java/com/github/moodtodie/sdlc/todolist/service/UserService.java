package com.github.moodtodie.sdlc.todolist.service;

import com.github.moodtodie.sdlc.todolist.dto.UserDto;
import com.github.moodtodie.sdlc.todolist.model.UserEntity;
import com.github.moodtodie.sdlc.todolist.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);
  @Autowired
  UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public boolean registerUser(UserDto user) {
    if (findUser(user.getUsername()) != null)
      return false;

    if (!user.getPassword().equals(user.getMatchingPassword()))
      return false;

    repository.save(new UserEntity(user.getUsername(), passwordEncoder.encode(user.getPassword()), user.getRole()));
    return true;
  }

  public UserEntity findUser(String username) {
    try {
      return repository.findByUsername(username).get();
    } catch (Exception ex) {
      logger.warn(ex.getMessage());
      return null;
    }
  }

  public Iterable<UserEntity> getAll() {
    return repository.findAll();
  }

  @Override
  public User loadUserByUsername(String username) throws UsernameNotFoundException {
    var userFromDb = repository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("No user found with this email address."));
    List<GrantedAuthority> authorities = new java.util.ArrayList<>(Collections.emptyList());

    authorities.add((GrantedAuthority) userFromDb::getRole);

    return new User(userFromDb.getUsername(), userFromDb.getPassword(), authorities);
  }
}
